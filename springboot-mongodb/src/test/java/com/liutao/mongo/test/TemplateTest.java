package com.liutao.mongo.test;

import com.liutao.mongo.application.Application;
import com.liutao.mongo.template.TemplateDemo;
import com.liutao.publiz.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: LIUTAO
 * @Date: Created in 2018/11/30  18:46
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TemplateTest {

    @Autowired
    private TemplateDemo templateDemo;

    @Test
    public void test(){
        User user = new User(1,"jock2","jock2@126.com","123123");
        templateDemo.saveUser(user,"users");
        user = templateDemo.findByUsername("jock2","users");
        System.out.println(user);
    }
}
