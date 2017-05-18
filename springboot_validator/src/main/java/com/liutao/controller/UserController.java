package com.liutao.controller;

import com.liutao.model.User;
import com.liutao.service.UserService;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * 用户控制层
 *
 * @author LIUTAO
 * @version 2017/3/29
 * @see
 * @since
 */
@Validated
@Controller
@Api(value = "test")
@RequestMapping("/liutao/v1")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView getUserInfo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","熊大");
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @GetMapping("/user")
    public @ResponseBody String check(@Min(value = 10,message = "名字长度必须大于10") @RequestParam int age) {
        return "ok";
    }

    @PostMapping(value = "/user")
    public @ResponseBody String postUser(@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            StringBuilder stringBuilder = new StringBuilder();
            for(ObjectError  error:list){
                stringBuilder.append(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
                logger.debug(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
            }

            return stringBuilder.toString();
        }
        return "success";
    }

}
