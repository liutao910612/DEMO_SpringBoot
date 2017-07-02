package com.liutao.service;

import com.liutao.entity.User;
import com.liutao.tag.model.RequestModel;

import java.util.List;

public interface UserService {
    List<User> getUserList(RequestModel requestModel);
    int countUsers();
}
