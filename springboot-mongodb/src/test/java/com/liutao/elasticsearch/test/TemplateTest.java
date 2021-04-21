package com.liutao.elasticsearch.test;

import com.liutao.mongo.application.Application;
import com.liutao.mongo.template.TemplateDemo;
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
//        User user = new User(2,"liubang","liubang123131232@126.com","gdsfggsd123123");
//        templateDemo.saveUser(user,"users");
//        user = templateDemo.findByUsername("jock2","users");
//        System.out.println(user);

//        System.out.println(templateDemo.findUsersByUsername("liubang","users"));
//        System.out.println(templateDemo.deleteUserByUser(new User(1,"jock","jock@126.com","123")));
        System.out.println(templateDemo.updateUserByUsername("liubang","liusanwa","users"));
    }
}
