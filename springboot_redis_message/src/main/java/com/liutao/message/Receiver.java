package com.liutao.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * 消息接收者
 *
 * @author LIUTAO
 * @version 2017/5/17
 * @see
 * @since
 */
public class Receiver {
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);
    private CountDownLatch countDownLatch;

    @Autowired
    public Receiver(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    public void receiveMessage(String message){
        logger.debug("Received <"+message+">");
        countDownLatch.countDown();
    }
}
