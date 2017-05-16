package com.liutao.userTest;

import com.liutao.application.Application;
import com.liutao.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * 测试类
 *
 * @author LIUTAO
 * @version 2017/3/29
 * @see
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUserInfoTest(){
        System.out.println(userMapper.getList());
    }

}
