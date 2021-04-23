package com.liutao.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器测试
 *
 * @author LIUTAO
 * @version 2017/5/19
 * @see
 * @since
 */
@Component
public class SchedulerOne {
    private Logger logger = LoggerFactory.getLogger(SchedulerOne.class);

    @Scheduled(cron = "0/20 * * * * ?")
    public void scheduler(){
        logger.debug("schedule continue");
    }
}
