package com.liutao.controller;

import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 用户控制层
 *
 * @author LIUTAO
 * @version 2017/3/29
 * @see
 */
@RestController
@Api(value = "test")
@RequestMapping("/liutao/v1")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 缓存测试
     *
     * @return
     * @author SHANHY
     * @create 2016年9月12日
     */
    @GetMapping("/redisTest")
    public String redisTest() {
        try {
            redisTemplate.opsForValue().set("test-key", "redis测试内容", 5, TimeUnit.SECONDS);// 缓存有效期5秒
            logger.info("从Redis中读取数据：" + redisTemplate.opsForValue().get("test-key").toString());
            TimeUnit.SECONDS.sleep(3);
            logger.info("等待3秒后从Redis中读取数据：" + redisTemplate.opsForValue().get("test-key").toString());
            TimeUnit.SECONDS.sleep(3);
            logger.info("等待5秒后尝试读取过期的数据：" + redisTemplate.opsForValue().get("test-key"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "OK";
    }
}
