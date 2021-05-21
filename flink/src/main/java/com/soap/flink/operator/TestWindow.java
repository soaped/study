package com.soap.flink.operator;

import com.soap.flink.source.PeriodicitySource;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.ProcessAllWindowFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.ProcessingTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import org.joda.time.DateTime;

/**
 * @author yangfuzhao on 2021/5/13.
 */
@Slf4j
public class TestWindow {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Integer> dataStreamSource = env.addSource(new PeriodicitySource(100));

        /**
         * timeWindowAll : TumblingWindow
         * TumblingProcessingTimeWindows:size 滚动窗口大小； offset 偏移修正,如果不设置，将会已整分，整小时切分窗口
         * dataStreamSource.windowAll(TumblingProcessingTimeWindows.of(Time.minutes(1),Time.seconds(20)))
         * 按北京时间划分天
         * dataStreamSource.windowAll(TumblingProcessingTimeWindows.of(Time.days(1),Time.hours(-8)))
         * 窗口赋值函数：
         * trigger: 定义触发窗口操作，会有默认值
         * evictor:
         * allowedLateness: 永许延迟的时间，参数大于0时窗口会延迟关闭。
         * sideOutputLateData: 延迟数据输出
         */


//        dataStreamSource.windowAll(TumblingProcessingTimeWindows.of(Time.days(1),Time.hours(-8)))
//
//                .process(new ProcessAllWindowFunction<Integer, Object, TimeWindow>() {
//                    @Override
//                    public void process(Context ctx, Iterable<Integer> elements, Collector<Object> out) {
//                        TimeWindow window = ctx.window();
//                        log.info("maxTimestamp:【{}】", new DateTime(window.maxTimestamp()).toLocalDateTime());
//                        log.info("start:【{}】", new DateTime(window.getStart()).toLocalDateTime());
//                        log.info("end:【{}】", new DateTime(window.getEnd()).toLocalDateTime());
//                        elements.forEach(out::collect);
//                    }
//                }).print("windowAll");

        dataStreamSource.keyBy((KeySelector<Integer, Object>) value -> value)
        .window(ProcessingTimeSessionWindows.withGap(Time.seconds(5)))
//                .trigger()
//                .evictor()
                .process(new ProcessWindowFunction<Integer, Object, Object, TimeWindow>() {
                    @Override
                    public void process(Object o, Context ctx, Iterable<Integer> elements, Collector<Object> out) throws Exception {
                        log.info("xxxx:【{}】", o);
                        TimeWindow window = ctx.window();
                        log.info("maxTimestamp:【{}】", new DateTime(window.maxTimestamp()).toLocalDateTime());
                        log.info("start:【{}】", new DateTime(window.getStart()).toLocalDateTime());
                        log.info("end:【{}】", new DateTime(window.getEnd()).toLocalDateTime());
                        elements.forEach(out::collect);
                    }
                })

                .print("windowAll");
        ;

        env.execute();
    }
}
