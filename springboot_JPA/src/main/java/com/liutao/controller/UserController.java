package com.liutao.controller;

import com.liutao.model.User;
import com.liutao.service.UserService;
import com.wordnik.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liutao on 2015/8/27.
 */
@RestController
@Api(value = "test",description = "this api is used to jpa_demo")
@RequestMapping("/liutao/v1")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @ApiOperation(value = "getUserInfo", notes = "this is used to find user by name.")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public User getUserInfo(@ApiParam(required = true, name = "name", value  = "find reason")
                                @RequestParam(value="name",defaultValue = "liubei") String name) {
        logger.info("name:"+name);
        User user = userService.getUserInfo(name);
        if(user!=null){
            logger.info("user.getAge():"+user.getAge());
        }
        return user;
    }



}
