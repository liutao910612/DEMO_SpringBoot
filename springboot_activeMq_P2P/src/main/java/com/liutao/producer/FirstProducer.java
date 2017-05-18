package com.liutao.producer;

import com.liutao.enums.QueueName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.Queue;

/**
 * 消息生产者
 *
 * @author LIUTAO
 * @version 2017/5/18
 * @see
 */
@Component
public class FirstProducer{
    private static final Logger logger = LoggerFactory.getLogger(FirstProducer.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    public void send(String message){
        this.jmsMessagingTemplate.convertAndSend(queue,message);
    }
}
