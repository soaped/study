package com.soap.study.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangfuzhao on 2020/4/13.
 */
public class ThreadLocaleTest {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>() {
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }
        };

        ExecutorService ts = Executors.newFixedThreadPool(100);
//        for (;;) {
//            ts.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        //生成随机数，格式化日期
//                        String format = sdf.format(new Date(Math.abs(new Random().nextLong())));
//                        System.out.println(format);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        System.exit(1);
//                    }
//                }
//            });
//        }

        for (;;) {
            ts.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //生成随机数，格式化日期
                        String format = tl.get().format(new Date(Math.abs(new Random().nextLong())));
                        System.out.println(format);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            });
        }

    }


}
