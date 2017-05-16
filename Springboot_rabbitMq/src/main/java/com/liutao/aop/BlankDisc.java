package com.liutao.aop;

import org.apache.log4j.Logger;
import java.util.List;

/**
 * 演示通知中带有参数的情况
 * Created by liutao on 2017/3/19.
 */
public class BlankDisc {
    private String title;
    private String artist;
    private List<String> tracks;
    private Logger logger = Logger.getLogger(BlankDisc.class);

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public void playTrack(int trackNumber){
        logger.info("***********Playing "+title+" by "+artist);
        logger.info("*******Track: "+tracks.get(trackNumber));
    }
}
