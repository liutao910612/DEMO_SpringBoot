package com.liutao.dao;

import com.liutao.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 日志持久层JPA
 *
 * @author LIUTAO
 * @version 2017/3/28
 * @see
 * @since
 */
@CacheConfig(cacheNames = "users")            //缓存配置注解
public interface UserDao extends JpaRepository<User,Integer> {
    @Cacheable
    public User findUserInfoByName(String name);
}
