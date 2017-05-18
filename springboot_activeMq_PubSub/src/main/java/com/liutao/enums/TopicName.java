package com.liutao.enums;

/**
 * 消息队列枚举类
 *
 * @author LIUTAO
 * @version 2017/5/18
 * @see
 * @since
 */

public enum TopicName {
    FIRST_TOPIC("first_topic"),
    SECOND_TOPIC("second_topic");
    private String message;
    TopicName(String message){
        this.message = message;
    }

    public String getValue(){
        return this.message;
    }
}
