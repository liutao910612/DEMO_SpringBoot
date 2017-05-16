package com.liutao.service.impl;

import com.liutao.entity.User;
import com.liutao.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LIUTAO
 * @version 2017/5/10
 * @see
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findByName(String loginName) {
        return null;
    }

    @Override
    public List<User> getList() {
        return null;
    }
}
