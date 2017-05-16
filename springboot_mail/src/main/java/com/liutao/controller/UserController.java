package com.liutao.controller;

import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.internet.MimeMessage;

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
    JavaMailSender mailSender;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView getUserInfo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","熊大");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
