package com.liutao.controller;

import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

/**
 * 员工Controller
 *
 * @author LIUTAO
 * @version 2017/5/19
 * @see
 * @since
 */

@RestController
@Api(value = "test employee")
@RequestMapping("/liutao/v1")
@Validated
public class EmployeeController {

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employee")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String check(@RequestParam @Min(value = 10,message = "名字长度必须大于10") int age) {
        logger.debug("enter employee get");
        return "ok";
    }
}
