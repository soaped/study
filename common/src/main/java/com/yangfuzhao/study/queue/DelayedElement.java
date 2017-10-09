package com.yangfuzhao.study.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by ipaynow0929 on 2017/10/9.
 */
public class DelayedElement implements Delayed {
    @Override
    //获取失效时间
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    //比较 1是放入队尾  -1是放入队头
    public int compareTo(Delayed o) {
        return 0;
    }
}
