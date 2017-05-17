package com.liutao.controller;

import com.liutao.entity.User;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.liutao.utils.RedisClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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
    private RedisClient redisClient;
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
            redisClient.putObject("test-key", "redis测试内容", 5);// 缓存有效期5秒
            logger.info("从Redis中读取数据：" + redisClient.getObject("test-key").toString());
            TimeUnit.SECONDS.sleep(3);
            logger.info("等待3秒后从Redis中读取数据：" + redisClient.getObject("test-key").toString());
            TimeUnit.SECONDS.sleep(3);
            logger.info("等待5秒后尝试读取过期的数据：" + redisClient.getObject("test-key"));

            redisClient.putObject("user",new User("张三","zs123"),10);
            logger.info("从Redis中读取数据User：" + redisClient.getObject("user"));

            List<String> list = new ArrayList<>();
            list.add("张飞");
            list.add("刘备");
            list.add("关于");
            redisClient.putObject("list",list,5);
            TimeUnit.SECONDS.sleep(3);
            logger.info("从Redis中读取数据User：" + redisClient.getObject("list"));
            TimeUnit.SECONDS.sleep(3);
            logger.info("从Redis中读取数据list：" + redisClient.getObject("list"));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "OK";
    }
}
