package com.liutao.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 消息生产者
 *
 * @author: LIUTAO
 * @Date: Created in 2019/5/29  15:00
 * @Modified By:
 */
@Component
public class MsgProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMsg(String topicName, String jsonData) {
        kafkaTemplate.send(topicName, jsonData);
    }


}
