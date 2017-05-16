package com.liutao.controller;

import com.liutao.model.User;
import com.liutao.service.UserService;
import com.wordnik.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zl on 2015/8/27.
 */
@RestController
@Api(value = "test")
@RequestMapping("/liutao/v1")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public User getUserInfo() {
        User user = userService.getUserInfo();
        if(user!=null){
            logger.info("user.getAge():"+user.getAge());
        }
        return user;
    }
}
