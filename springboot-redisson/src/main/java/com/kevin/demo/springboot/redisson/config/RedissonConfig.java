package com.kevin.demo.springboot.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * <p>
 * Redisson config
 * </p>
 *
 * @author alvinl
 * @date 04/27/21 17:25
 **/
@Configuration
public class RedissonConfig {

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() throws IOException {
        RedissonClient redissonClient = Redisson.create(
                Config.fromYAML(new ClassPathResource("redisson-single.yml").getInputStream()));
        return redissonClient;
    }
}
