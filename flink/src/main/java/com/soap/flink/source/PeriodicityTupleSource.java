package com.soap.flink.source;

import com.google.common.collect.Lists;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.List;

/**
 * @author yangfuzhao on 2021/5/11.
 * 从指定数据源周期性产生数据
 */
public class PeriodicityTupleSource implements SourceFunction<Tuple2<String,List<Integer>>> {


    private boolean flag = Boolean.TRUE;

    private int periodicity;

    public PeriodicityTupleSource() {
        periodicity = 5;
    }

    public PeriodicityTupleSource(int periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public void run(SourceContext<Tuple2<String,List<Integer>>> ctx) throws Exception {
        List<Integer> list = Lists.newArrayList(2, 2, 1, 3, 1, 4, 1, 5, 2, 6, 7);

        int i = 0;
        while (flag) {
            Thread.sleep(periodicity);
            if (i == list.size()) {
                i = 0;
            }
            ctx.collect(new Tuple2(""+i,list));
        }
    }

    @Override
    public void cancel() {
        flag = Boolean.FALSE;
    }
}
