package com.liutao.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

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
    @Autowired
    private Topic topic;

    public void send(String message){
        this.jmsMessagingTemplate.convertAndSend(queue,message);
        this.jmsMessagingTemplate.convertAndSend(topic,message);
    }
}
