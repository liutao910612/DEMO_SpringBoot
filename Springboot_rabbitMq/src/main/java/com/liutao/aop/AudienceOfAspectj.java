package com.liutao.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 用于演示AspectJ
 * Created by liutao on 2017/3/19.
 */
@Aspect
public class AudienceOfAspectj {
    Logger logger = Logger.getLogger(AudienceOfAspectj.class);
    @Pointcut("execution(** com.liutao.aop.PerformanceOfAspectJ.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhone(){
        logger.info("******* cellPhone silence ************");
    }

    @Before("performance()")
    public void takeSeats(){
        logger.info("******* please take seats ************");
    }

    @AfterReturning("performance()")
    public void applause(){
        logger.info("******* CLAP CLAP CLAP ************");
    }

}
