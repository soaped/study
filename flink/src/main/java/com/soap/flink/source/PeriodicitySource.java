package com.soap.flink.source;

import com.google.common.collect.Lists;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.List;

/**
 * @author yangfuzhao on 2021/5/11.
 * 从指定数据源周期性产生数据
 */
@Slf4j
public class PeriodicitySource implements SourceFunction<Integer> {


    private boolean flag = Boolean.TRUE;

    /**
     * 每隔多少毫秒发送一次数据
     */
    private int periodicity;

    public PeriodicitySource() {
        periodicity = 5;
    }

    public PeriodicitySource(int periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public void run(SourceContext ctx) throws Exception {
        List list = Lists.newArrayList(2, 2, 1, 3, 1, 4, 1, 5, 2, 6, 7);
        ctx.collect(10);
        int i = 0;
        while (flag) {
            Thread.sleep(periodicity);
            if (i == list.size()) {
                i = 0;
            }
            Object o = list.get(i++);
            ctx.collect(o);
            log.info("xxxx:【{}】",o);
        }
    }

    @Override
    public void cancel() {
        flag = Boolean.FALSE;
    }
}
