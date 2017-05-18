package com.liutao.service.impl;

import com.liutao.mapper.UserMapper;
import com.liutao.model.User;
import com.liutao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(){
        User user=userMapper.findUserInfo();
        return user;
    }

}
