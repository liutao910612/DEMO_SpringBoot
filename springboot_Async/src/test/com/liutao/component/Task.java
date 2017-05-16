package com.liutao.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * 演示@Async实现异步调用
 *
 * @author LIUTAO
 * @version 2017/5/9
 * @see
 * @since
 */
@Component
public class Task {
    private static Random random = new Random();

    @Async
    public Future<String> doTaskOne() throws InterruptedException {
        System.out.println("begin task-one");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long endTime = System.currentTimeMillis();
        System.out.println("the time of completing task-one :"+(endTime-startTime));
        return new AsyncResult<>("task-one finish");
    }

    @Async
    public Future<String> doTaskTwo() throws InterruptedException {
        System.out.println("begin task-two");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long endTime = System.currentTimeMillis();
        System.out.println("the time of completing task-two :"+(endTime-startTime));
        return new AsyncResult<>("task-two finish");
    }

    @Async
    public Future<String> doTaskThree() throws InterruptedException {
        System.out.println("begin task-three");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long endTime = System.currentTimeMillis();
        System.out.println("the time of completing task-three :"+(endTime-startTime));
        return new AsyncResult<>("task-three finish");
    }

}
