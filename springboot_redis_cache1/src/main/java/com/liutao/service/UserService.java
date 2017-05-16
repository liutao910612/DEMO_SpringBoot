package com.liutao.service;

import com.liutao.entity.User;

public interface UserService {
    User findById(Integer id);
    void deleteFromCache(Integer id);
}
