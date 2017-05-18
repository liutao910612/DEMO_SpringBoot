package com.liutao.consumer;

import com.liutao.enums.QueueName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 *
 * @author LIUTAO
 * @version 2017/5/18
 * @see
 * @since
 */
@Component
public class SecondConsumer {
    private static final Logger logger = LoggerFactory.getLogger(SecondConsumer.class);

    @JmsListener(destination = "first_queue")
    public void receiveQueue(String message){
        logger.debug("this is second consumer");
        logger.debug("the message received from "+ QueueName.FIRST_QUEUE.getValue()+" is: "+message);
    }
}
