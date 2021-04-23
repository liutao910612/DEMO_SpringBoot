package com.liutao.cache.manager;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

/**
 * Local cache by Guava
 *
 * @author alvinl
 * @date 09/29/20 16:57
 **/
@Configuration
@ComponentScan
@Qualifier("localCacheService")
public class LocalCacheProviderImpl implements CacheProviderService {

    private static Map<String, Cache<String, Object>> _cacheMap = Maps.newConcurrentMap();

    private static final Long CACHE_MAXIMUM_SIZE = 10000L;
    private static final Long CACHE_MINUTE = 60000L;
    private static Lock lock = new ReentrantLock();

    static {

        Cache<String, Object> cacheContainer = CacheBuilder.newBuilder()
                .maximumSize(CACHE_MAXIMUM_SIZE)
                .expireAfterWrite(CACHE_MINUTE, TimeUnit.MILLISECONDS)
                .recordStats()
                .build();

        _cacheMap.put(String.valueOf(CACHE_MINUTE), cacheContainer);
    }

    @Override
    public <T> T get(String key) {
        return get(key, null, null, CACHE_MINUTE);
    }

    @Override
    public <T> T get(String key, Function<String, T> function) {
        return get(key, function, null, CACHE_MINUTE);
    }

    @Override
    public <T, M> T get(String key, Function<M, T> function, M funcParm) {
        return get(key, function, funcParm, CACHE_MINUTE);
    }

    @Override
    public <T> T get(String key, Function<String, T> function, Long expireTime) {
        return get(key, function, null, expireTime);
    }

    @Override
    public <T, M> T get(String key, Function<M, T> function, M funcParm, Long expireTime) {
        T obj = null;
        if (StringUtils.isEmpty(key)) {
            return obj;
        }

        expireTime = getExpireTime(expireTime);
        Cache<String, Object> cacheContainer = getCacheContainer(expireTime);
        if(ObjectUtils.isEmpty(function)){
            obj = (T)cacheContainer.getIfPresent(key);
        }else {
            try {
                obj = (T)cacheContainer.get(key,() ->{
                    T retObj = function.apply(funcParm);
                    return retObj;
                });
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    @Override
    public <T> void set(String key, T obj) {
        set(key,obj,CACHE_MINUTE);
    }

    @Override
    public <T> void set(String key, T obj, Long expireTime) {
        if(ObjectUtils.isEmpty(key) || ObjectUtils.isEmpty(obj)){
            return;
        }

        expireTime = getExpireTime(expireTime);
        Cache<String,Object> cacheContainer = getCacheContainer(expireTime);
        cacheContainer.put(key,obj);


    }

    @Override
    public void remove(String key) {
        if(StringUtils.isEmpty(key)){
            return;
        }
        Cache<String,Object> cacheContainer = getCacheContainer(CACHE_MINUTE);
        cacheContainer.invalidate(key);
    }

    @Override
    public boolean contains(String key) {
        return !StringUtils.isEmpty(key) && get(key) != null;
    }

    private Long getExpireTime(Long expireTime) {
        Long result = expireTime;
        if(ObjectUtils.isEmpty(expireTime)
                || expireTime < CACHE_MINUTE/10){
            result = CACHE_MINUTE;
        }
        return result;
    }

    private Cache<String, Object> getCacheContainer(Long expireTime) {
        Cache<String, Object> cacheContainer = null;
        if (ObjectUtils.isEmpty(expireTime)) {
            return cacheContainer;
        }

        String mapKey = String.valueOf(expireTime);
        if (_cacheMap.containsKey(mapKey)) {
            cacheContainer = _cacheMap.get(mapKey);
            return cacheContainer;
        }

        try {
            lock.lock();
            cacheContainer = CacheBuilder
                    .newBuilder()
                    .maximumSize(CACHE_MAXIMUM_SIZE)
                    .expireAfterWrite(expireTime, TimeUnit.MICROSECONDS)
                    .recordStats()
                    .build();
            _cacheMap.put(mapKey, cacheContainer);
        } finally {
            lock.unlock();
        }
        return cacheContainer;
    }
}
