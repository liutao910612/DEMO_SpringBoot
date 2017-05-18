package com.liutao.controller;

import com.liutao.producer.FirstProducer;
import com.wordnik.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ActiveMq测试
 *
 * @author LIUTAO
 * @version 2017/5/18
 * @see
 */
@Controller
@Api(value = "test activeMQ")
@RequestMapping("/liutao/v1")
public class ActiveMq {

    private Logger logger = LoggerFactory.getLogger(ActiveMq.class);

    @Autowired
    private FirstProducer firstProducer;

    @GetMapping("/activeMq")
    public
    @ResponseBody
    String activeMq(@RequestParam("message") String message) {
        logger.debug("enter test activeMq");
        message = StringUtils.isEmpty(message) ? "this is a empty message" : message;
        firstProducer.send(message);
        return "OK";
    }

}
