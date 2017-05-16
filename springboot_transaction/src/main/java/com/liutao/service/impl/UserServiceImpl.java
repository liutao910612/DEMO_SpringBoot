package com.liutao.service.impl;

import com.liutao.mapper.UserMapper;
import com.liutao.model.User;
import com.liutao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    public User getUserInfo(){
        User user=userMapper.findUserInfo();
        return user;
    }

    @Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addUsers() throws Exception {
        for (int i = 0 ;i<10;i++){
            User user = new User("test"+i,10+i,"test"+i+"test");
            userMapper.addUser(user);
            if (i == 11){
                throw  new Exception();
            }

        }
    }

}
