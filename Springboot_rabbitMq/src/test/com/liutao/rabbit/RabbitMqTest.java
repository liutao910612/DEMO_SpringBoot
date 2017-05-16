package com.liutao.rabbit;

import com.liutao.application.Application;
import com.liutao.rabbitMQ.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Rabbit测试类
 *
 * @author LIUTAO
 * @version 2017/4/24
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RabbitMqTest {
    @Autowired
    private Sender sender;

    @Test
    public void testRabbitMq(){
        sender.send();
    }
}
