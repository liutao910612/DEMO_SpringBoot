package com.liutao.rabbitMQ;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息生产者
 *
 * @author LIUTAO
 * @version 2017/4/24
 * @see
 * @since
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    private Logger logger = Logger.getLogger(Sender.class);
    public void send(){
        String context = "hello "+ new Date();
        logger.debug("enter send");
        amqpTemplate.convertAndSend("hello",context);
    }
}
