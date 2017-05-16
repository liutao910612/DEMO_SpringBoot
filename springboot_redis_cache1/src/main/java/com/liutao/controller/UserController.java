package com.liutao.controller;

import com.liutao.entity.User;
import com.liutao.service.UserService;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户控制层
 *
 * @author LIUTAO
 * @version 2017/3/29
 * @see
 * @since
 */
@Controller
@Api(value = "test")
@RequestMapping("/liutao/v1")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userServiceImpl;

    @GetMapping("/user")
    public @ResponseBody String test(){
        User userOfload = userServiceImpl.findById(1);
        logger.debug("userOfload:"+userOfload);
        User userOfCached = userServiceImpl.findById(1);
        logger.debug("userOfCached:"+userOfCached);
        userOfload = userServiceImpl.findById(2);
        logger.debug("userOfload2:"+userOfload);
        return "ok";

    }

    @DeleteMapping("/userOfCache")
    public @ResponseBody String delete(Integer id){
        userServiceImpl.deleteFromCache(id);
        return "ok";
    }

    @GetMapping("user2")
    public @ResponseBody String testTwo(){
        logger.debug("UserController.testTwo()");
        return "ok";
    }
}
