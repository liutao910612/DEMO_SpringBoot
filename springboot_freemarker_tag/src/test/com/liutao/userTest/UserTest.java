package com.liutao.userTest;

import com.liutao.application.Application;
import com.liutao.service.UserService;
import com.liutao.tag.model.RequestModel;
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
    private UserService userServiceImpl;

    @Test
    public void getUserInfoTest(){
        RequestModel p = new RequestModel();
        p.setPage(1);
        p.setRows(5);
        p.setSort("age");
        System.out.println(userServiceImpl.getUserList(p));
    }

}
