package com.xyls.study.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * Created by ipaynow0929 on 2017/10/9.
 */
public class DelayQueueExample {
    public static void main(String[] args) {
        DelayQueue queue = new DelayQueue();
        Delayed element1 = new DelayedElement();
        queue.put(element1);
        try {
            Delayed element2 = queue.take();
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
