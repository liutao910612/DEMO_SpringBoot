package com.liutao.config;

import com.liutao.aop.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2017/3/19.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AopOfAspectJConfig {
    @Bean
    public AudienceOfAspectj audience(){
        return new AudienceOfAspectj();
    }

    @Bean
    public AudienceOfAround audienceOfAround(){
        return new AudienceOfAround();
    }



    @Bean
    public BlankDisc blankDisc(){
        String title = "country";
        String artist = "jok";
        List<String> tracks = new ArrayList<String>();
        tracks.add("liu");
        tracks.add("guan");
        tracks.add("zhang");
        tracks.add("zhao");
        return new BlankDisc(title,artist,tracks);
        }

    @Bean
    public TrackCounter trackCounter(){
        return new TrackCounter();
    }
        }
