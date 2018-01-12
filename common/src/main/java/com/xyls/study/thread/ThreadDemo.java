package com.xyls.study.thread;

import org.joda.time.DateTime;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ipaynow0929 on 2017/12/28.
 */
public class ThreadDemo {

    public static void main(String[] args) {
        System.out.println("时间:" + new DateTime().toString("yyyyMMdd HH:mm:ss"));
    }

    @Test
    public void cacheThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i<10;i++){
            final int index = i;

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index + Thread.currentThread().getName() + "时间:" + new DateTime().toString("yyyyMMdd HH:mm:ss"));
                    try {
                        Thread.sleep(index * 1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    }
                }
            });
        }
    }

    @Test
    public void cheduledThreatPool(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5) ;
        for (int i = 0; i<10;i++){
            final int index = i;

//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(index + Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(index*1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } finally {
//                    }
//                }
//            });

            scheduledExecutorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("时间:" + new DateTime().toString("yyyyMMdd HH:mm:ss"));
                }
            },0, TimeUnit.SECONDS);
        }
    }
}
