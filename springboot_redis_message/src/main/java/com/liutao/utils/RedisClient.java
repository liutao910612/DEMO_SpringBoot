package com.liutao.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis客户端工具类
 *
 * @author LIUTAO
 * @version 2017/5/15
 * @see
 */
@Component
public class RedisClient {
    private static Logger logger = LoggerFactory.getLogger(RedisClient.class);
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 保存数据进入缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 缓存时间
     */
    public void putObject(final String key, final Object value, final int cacheSeconds) {
        redisTemplate.opsForValue().set(key, value, cacheSeconds, TimeUnit.SECONDS);
    }

    /**
     * get操作
     *
     * @param key 键
     * @return
     */
    public Object getObject(final String key) {
        return redisTemplate.opsForValue().get(key);
    }


    /**
     * 从缓存中删除对象
     *
     * @param key 键
     * @return
     */
    public int del(final String key) {
        try {
            redisTemplate.delete(key);
            return 1;
        } catch (Exception e) {
            return 0;
        }

    }

    /**
     * 判断缓存数据是否存在
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }
}
