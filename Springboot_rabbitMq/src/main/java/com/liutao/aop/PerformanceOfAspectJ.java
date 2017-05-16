package com.liutao.aop;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 演示AspectJ
 * Created by liutao on 2017/3/19.
 */
@Component
public class PerformanceOfAspectJ {
    Logger logger = Logger.getLogger(PerformanceOfAspectJ.class);
    public void perform(){
        logger.info("#########################");
        logger.info("##### this is perform ####");
        logger.info("#########################");
    }
}
