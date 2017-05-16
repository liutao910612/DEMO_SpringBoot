package com.liutao.controller;

import com.liutao.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试SpringSecurity
 *
 * @author LIUTAO
 * @version 2017/5/10
 * @see
 * @since
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){

        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user")User user) {
        return "index";
    }
}
