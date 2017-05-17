package com.liutao.redisTest;

import com.liutao.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试redis缓存
 *
 * @author LIUTAO
 * @version 2017/4/27
 * @see
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class redisCache {
    private Logger logger = LoggerFactory.getLogger(redisCache.class);
    @Autowired
    private CacheManager cacheManager;
    @Test
    public void test() throws Exception {
    }
}
