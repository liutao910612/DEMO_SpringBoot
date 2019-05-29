package com.liutao.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: LIUTAO
 * @Date: Created in 2018/11/30  18:46
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaApplication.class)
public class KakfaTest {

    @Autowired
    private MsgProducer msgProducer;
    @Test
    public void test(){
       msgProducer.sendMsg("topic-1","wahaha");
    }
}
