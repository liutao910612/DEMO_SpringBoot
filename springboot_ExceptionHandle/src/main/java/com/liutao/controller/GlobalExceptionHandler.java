package com.liutao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理类
 *
 * @author LIUTAO
 * @version 2017/4/25
 * @see
 * @since
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultExceptionHandle(HttpServletRequest req, Exception e){
        logger.debug("enter error handler");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Exception",e);
        modelAndView.addObject("url",req.getRequestURL());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        logger.debug("outer error handler");
        return modelAndView;
    }
}
