package com.liutao.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import java.util.HashMap;
import java.util.Map;

/**
 * 演示通知中带有参数的情况
 * Created by liutao on 2017/3/19.
 */
@Aspect
public class TrackCounter {
    private Map<Integer,Integer> trackCounts = new HashMap<Integer, Integer>();

    public Map<Integer, Integer> getTrackCounts() {
        return trackCounts;
    }

    public void setTrackCounts(Map<Integer, Integer> trackCounts) {
        this.trackCounts = trackCounts;
    }

    @Pointcut("execution(* com.liutao.aop.BlankDisc.playTrack(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber){}

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber){
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber,currentCount+1);
    }

    private int getPlayCount(int trackNubmer) {
        return trackCounts.containsKey(trackNubmer) ? trackCounts.get(trackNubmer) : 0;
    }


}
