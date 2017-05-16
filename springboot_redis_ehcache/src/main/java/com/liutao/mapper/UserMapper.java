package com.liutao.mapper;

import com.liutao.model.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * 用户数据访问
 *
 * @author LIUTAO
 * @version 2017/3/29
 * @see
 * @since
 */

public interface UserMapper {
    public User findUserInfo();
    public User findUserInfoByName(String name);
    public int updateUserInfo(User user);
    public int deleteUser(String name);
    public void addUser(User user);
}
