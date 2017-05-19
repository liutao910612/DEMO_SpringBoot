package com.liutao.controller;

import com.liutao.model.Company;
import com.liutao.utilitys.ValidateUtility;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 公司Controller
 *
 * @author LIUTAO
 * @version 2017/5/19
 * @see
 */
@RestController
@Api(value = "test company")
@RequestMapping("/liutao/v1")
public class CompanyController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = "/company")
    public String postCompany(@Valid @RequestBody Company company, BindingResult result,HttpServletResponse response){
        return ValidateUtility.judgeValidate(result,response);
    }
}
