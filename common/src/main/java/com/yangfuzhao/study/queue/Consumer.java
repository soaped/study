package com.yangfuzhao.study.queue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by ipaynow0929 on 2017/10/9.
 */
public class Consumer implements Runnable {
    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
