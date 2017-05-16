package com.liutao.aopTest;

import com.liutao.aop.BlankDisc;
import com.liutao.aop.PerformanceOfAspectJ;
import com.liutao.aop.TrackCounter;
import com.liutao.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by liutao on 2017/3/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class AopTest {
    @Autowired
    private PerformanceOfAspectJ performanceOfAspectJ;

    @Autowired
    private TrackCounter trackCounter;

    @Autowired
    private BlankDisc blankDisc;

    @Test
    public void testAopOfAspectJ(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("performanceOfAspectJ:"+performanceOfAspectJ);
        performanceOfAspectJ.perform();
    }

    @Test
    public void testAround(){
        performanceOfAspectJ.perform();
    }

    @Test
    public void testTrackCounterOfPam(){
        blankDisc.playTrack(1);
        blankDisc.playTrack(2);
        blankDisc.playTrack(2);
        blankDisc.playTrack(1);
        blankDisc.playTrack(2);
        blankDisc.playTrack(3);

        System.out.println(trackCounter.getTrackCounts().get(1));
        System.out.println(trackCounter.getTrackCounts().get(2));
        System.out.println(trackCounter.getTrackCounts().get(3));
    }
}
