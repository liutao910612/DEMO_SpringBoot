package com.liutao.userTest;

import com.liutao.application.Application;
import com.liutao.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by liutao on 2017/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserInfoTest(){
        System.out.println(userService.getUserInfo());
    }

    /**
     * 该注解表明在每个单元测试开始之后都要执行这个方法
     */
    @Before
    public void beforeTest(){
        System.out.println("test Begin");
    }

    /**
     * 该注解表明在每个单元测试之后都要执行这个方法
     */
    @After
    public void afterTest(){
        System.out.println("end test");
    }


}
