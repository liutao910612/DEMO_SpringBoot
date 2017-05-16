package com.liutao.redisTest;

import com.liutao.application.Application;
import com.liutao.dao.UserDao;
import com.liutao.mapper.UserMapper;
import com.liutao.model.User;
import org.junit.Before;
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
    private UserMapper userMapper;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CacheManager cacheManager;
    @Before
    public void before() {
        userMapper.addUser(new User("AAA", 10,"123"));
    }

    @Test
    public void test() throws Exception {
        com.liutao.entity.User u1 = userDao.findUserInfoByName("AAA");
        logger.debug("the user of first find:"+u1);
        com.liutao.entity.User u2 = userDao.findUserInfoByName("AAA");
        logger.debug("the user of second find:"+u2);
    }
}
