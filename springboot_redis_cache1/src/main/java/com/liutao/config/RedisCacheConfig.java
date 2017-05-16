package com.liutao.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * redis缓存配置，采用继承的方式来改变Spring的缓存策略。
 *
 * 注意：这里可以不用继承CachingConfigurerSupport，也就是一个普通的RedisCacheConfig亦可以。
 * 如果要从新实现key的生成策略，只要这里修改KeyGenerator就可以，其他地方不用修改。
 * 如果使用普通类，那么在使用@Cacheable的时候需要指定KeyGenarator的名字。
 * @author LIUTAO
 * @version 2017/5/15
 * @see
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    /**
     * 缓存管理器
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        //设置默认过期时间
        cacheManager.setDefaultExpiration(60);
        return cacheManager;
    }

    /**
     * redis模板操作类
     * 虽然CacheManager也能获取到Cache对象，但是操作起来不灵活
     *
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        return redisTemplate;
    }

    /**
     * 自定义Key
     * 此方法会根据类名+方法名+所有参数的值生成一个唯一的key，即使@Cacheable中的value一样，key也会不一样。
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator() {
        System.out.println("RedisCacheConfig.keyGenerator()");
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                System.out.println("keyGenerator=" + sb.toString());
                return sb.toString();
            }
        };
    }
}
