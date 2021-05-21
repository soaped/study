package com.soap.flink.operator;

import com.google.common.collect.Lists;
import com.soap.flink.source.PeriodicitySource;
import com.soap.flink.source.PeriodicityTupleSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.IterativeStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.api.functions.windowing.AllWindowFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessAllWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.SlidingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.SlidingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.util.List;

/**
 * @author yangfuzhao on 2021/5/11.
 */
@Slf4j
public class TestOperator {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Integer> dss1 = env.fromCollection(Lists.newArrayList(1, 2, 3,5,6,1,2,1,3,1,2));
        DataStreamSource<Integer> dss2 = env.fromCollection(Lists.newArrayList(4, 5, 6));

        DataStreamSource<Integer> dataStreamSource = env.addSource(new PeriodicitySource(1000));
//        DataStreamSource<Tuple2<String, List<Integer>>> tds = env.addSource(new PeriodicityTupleSource(1000));
//        dataStreamSource.print("###");

        /**
         * reduce
         * 0.只能用于keyStream
         * 1.第一次时,v1=v2;
         * 2.以后每次把结果放到v1继续计算
         */
//        dataStreamSource.keyBy((KeySelector<Integer, Integer>) value -> value)
//                .reduce((ReduceFunction<Integer>) (v1, v2) -> {
//                    System.out.print("v1=" + v1 + ",v2=" + v2);
//                    return v1 * v2;
//                }).print("reduce=");

        /**
         * aggregation
         * 0.只有在keyStream中使用
         * 1.minBy maxBy会继续比较字段中的值
         */

//        KeyedStream<Tuple2<String, List<Integer>>, Object> tks = tds.keyBy(new KeySelector<Tuple2<String, List<Integer>>, Object>() {
//            @Override
//            public Object getKey(Tuple2<String, List<Integer>> value) throws Exception {
//                return value.f1;
//            }
//        });
//
////        keyedStream.sum(0).print("sum=");
//        tks.max(0).print("min=");
////        keyedStream.max(0).print("max=");
//        tks.maxBy(0).print("minBy=");


/**
 *  DataStreamSource<Long> dss2 = env.fromCollection(Lists.newArrayList( 4L, 6L, 7L));
 *
 */
        /**
         *  union
         *  0.union 操作数据源类型必须一致
         *  1.可以跟自己，数据会出现两次
         *
         */
                dss1.union(dss2).process(new ProcessFunction<Integer, Object>() {

            @Override
            public void processElement(Integer value, Context ctx, Collector<Object> out) throws Exception {

            }
        });
//        dss1.join(dss2).where((KeySelector<Integer, Integer>) value -> value);
//        dss1.union(dss2).keyBy((KeySelector<Integer, Integer>)v->v)
//                .window(TumblingEventTimeWindows.of(Time.seconds(1)))
//            ;

        /**
         * iterate
         */
//        IterativeStream<Integer> iterate = dss1.iterate(10000);
//        iterate.map((MapFunction<Integer, Object>) value -> value).print("####");
//        iterate.closeWith(iterate);

        env.execute("");
    }
}
