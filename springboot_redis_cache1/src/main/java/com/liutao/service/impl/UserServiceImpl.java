package com.liutao.service.impl;

import com.liutao.dao.UserDao;
import com.liutao.entity.User;
import com.liutao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 用户服务层
 *
 * @author LIUTAO
 * @version 2017/3/29
 * @see
 * @since
 */






@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * 执行缓存
     * @param id
     * @return
     */
    @Cacheable(value="user",keyGenerator = "keyGenerator")                //缓存，这里没有指定Key
    @Override
    public User findById(Integer id) {
        logger.debug("the data coming from database is ："+id);
        return userDao.findOne(id);
    }

    /**
     * 清空缓存
     * @param id
     */
    @CacheEvict(value="user",allEntries = true)
    @Override
    public void deleteFromCache(Integer id) {
        logger.debug("delete from cache");
    }
}
