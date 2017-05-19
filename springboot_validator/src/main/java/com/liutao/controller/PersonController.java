package com.liutao.controller;

import com.liutao.model.Person;
import com.liutao.utilitys.ValidateUtility;
import com.liutao.validateInterface.PersonAddView;
import com.liutao.validateInterface.PersonUpdateView;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;

/**
 * 人员Controller
 *
 * @author LIUTAO
 * @version 2017/5/19
 * @see
 * @since
 */
@RestController
@Api(value = "test person")
@RequestMapping("/liutao/v1")
public class PersonController {

    private Logger logger = LoggerFactory.getLogger(PersonController.class);
    /**
     * 处@Validated(PersonAddView.class) 表示使用PersonAndView这套校验规则，若使用@Valid 则表示使用默认校验规则，
     * 若两个规则同时加上去，则只有第一套起作用
     *
     * @param person
     */
    @PostMapping(value = "/person")
    public String addPerson(@RequestBody @Validated({PersonAddView.class, Default.class}) Person person, BindingResult result,HttpServletResponse response) {
        logger.debug("enter post person");
        logger.debug("the information of person :"+ person);
        return ValidateUtility.judgeValidate(result,response);
    }

    /**
     * 修改Person对象
     * 此处启用PersonModifyView 这个验证规则
     * @param person
     */
    @PutMapping(value = "/person")
    public String modifyPerson(@RequestBody @Validated(value = {PersonUpdateView.class}) Person person, BindingResult result,HttpServletResponse response) {
        logger.debug("enter put person");
        logger.debug("the information of person :"+ person);
        return ValidateUtility.judgeValidate(result,response);
    }
}
