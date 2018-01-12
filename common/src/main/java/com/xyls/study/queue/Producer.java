package com.xyls.study.queue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by ipaynow0929 on 2017/10/9.
 */
public class Producer implements Runnable {
    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put("3");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
