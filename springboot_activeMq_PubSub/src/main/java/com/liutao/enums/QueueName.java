package com.liutao.enums;

/**
 * 消息队列枚举类
 *
 * @author LIUTAO
 * @version 2017/5/18
 * @see
 * @since
 */

public enum  QueueName{
    FIRST_QUEUE("first_queue"),
    SECOND_QUEUE("second_queue");
    private String message;
    QueueName(String message){
        this.message = message;
    }

    public String getValue(){
        return this.message;
    }
}
