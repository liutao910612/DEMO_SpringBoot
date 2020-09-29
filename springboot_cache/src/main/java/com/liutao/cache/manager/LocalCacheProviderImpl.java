package com.liutao.cache.manager;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Local cache by Guava
 * @author alvinl
 * @date 09/29/20 16:57
 **/
@Configuration
@ComponentScan
@Qualifier("localCacheService")
public class LocalCacheProviderImpl implements CacheProviderService {

    private static Map<String, Cache<String, Object>> _cacheMap = Maps.newConcurrentMap();

    private static final int CACHE_MAXIMUM_SIZE = 10000;
    private static final int CACHE_MINUTE = 60000;

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
        return null;
    }

    @Override
    public <T> T get(String key, Function<String, T> function) {
        return null;
    }

    @Override
    public <T, M> T get(String key, Function<M, T> function, M funcParm) {
        return null;
    }

    @Override
    public <T> T get(String key, Function<String, T> function, Long expireTime) {
        return null;
    }

    @Override
    public <T, M> T get(String key, Function<M, T> function, M funcParm, Long expireTime) {
        return null;
    }

    @Override
    public <T> void set(String key, T obj) {

    }

    @Override
    public <T> void set(String key, T obj, Long expireTime) {

    }

    @Override
    public void remove(String key) {

    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    private Long getExpireTime(Long expireTime){

        return expireTime;
    }
}
