package com.liutao.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: LIUTAO
 * @Date: Created in 2019/5/29  15:21
 * @Modified By:
 */
@Component
public class MsgConsumer {

    @KafkaListener(topics = {"topic-1", "topic-2"})
    public void processMessage(String content) {

        System.out.println("消息被消费" + content);
    }

}
