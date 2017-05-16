package com.liutao.service;

import com.liutao.entity.User;

import java.util.List;

/**
 * 用户服务类
 *
 * @author LIUTAO
 * @version 2017/5/10
 * @see
 */
public interface UserService {
    User findByName(String loginName);
    List<User> getList();
}
