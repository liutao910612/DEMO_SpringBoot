package com.kevin.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author alvinl
 * @date 10/09/20 15:58
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DemoTest {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void test(){
        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
        operations.set(1,"demo redis");
        System.out.println(operations.get(1));
    }
}
