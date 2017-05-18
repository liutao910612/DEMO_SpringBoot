package com.liutao.config;

import com.liutao.enums.QueueName;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * 消息队列配置类
 *
 * @author LIUTAO
 * @version 2017/5/18
 * @see
 * @since
 */
@Configuration
public class QueueConfig {
    @Bean
    public Queue queue(){
        return new ActiveMQQueue(QueueName.FIRST_QUEUE.getValue());
    }
}
