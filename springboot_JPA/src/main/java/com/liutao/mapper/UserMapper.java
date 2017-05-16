package com.liutao.mapper;

import com.liutao.model.User;

/**
 * Created by liutao on 2017/02/27.
 */
public interface UserMapper {
    public User findUserInfo(String name);
}
