package com.liutao.controller;

import com.liutao.commonUtility.CommonUtility;
import com.liutao.model.User;
import com.liutao.validatorUtility.ValidateUtility;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 用户控制层
 *
 * @author LIUTAO
 * @version 2017/3/29
 * @see
 */

@RestController
@Api(value = "test")
@RequestMapping("/liutao/v1")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = "/user")
    public
    @ResponseBody
    String postUser(@Valid @RequestBody User user, BindingResult result, HttpServletResponse response) {
        return ValidateUtility.judgeValidate(result,response).getMessage();
    }
}
