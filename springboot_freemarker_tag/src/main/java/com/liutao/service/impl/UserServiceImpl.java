package com.liutao.service.impl;

import com.liutao.entity.User;
import com.liutao.mapper.UserMapper;
import com.liutao.service.UserService;
import com.liutao.tag.model.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<User> getUserList(RequestModel requestModel) {
        return userMapper.getUserList(requestModel);
    }

    @Override
    public int countUsers() {
        return userMapper.countUsers();
    }
}
