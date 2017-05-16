package com.liutao.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 演示环绕通知
 * Created by liutao on 2017/3/19.
 */
@Aspect
public class AudienceOfAround {
    Logger logger = Logger.getLogger(AudienceOfAround.class);

    @Pointcut("execution(** com.liutao.aop.PerformanceOfAspectJ.perform(..))")
    public void performance(){}

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try {
            logger.info("############## Silencing cell phone ###############");
            logger.info("############## Taking seats ###############");
            joinPoint.proceed();
            logger.info("############## CLAP CLAP CLAP ###############");
        } catch (Throwable throwable) {
            logger.info("############## Demanding a refund ###############");
        }

    }
}
