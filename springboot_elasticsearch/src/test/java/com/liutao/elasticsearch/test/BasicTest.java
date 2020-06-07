package com.liutao.elasticsearch.test;

import com.liutao.es.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:LIUTAO
 * @Description:
 * @Date:Created in 10:14 2020/6/7
 * @Modified By:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class BasicTest {

    @Autowired
    protected RestHighLevelClient restClient;
}
