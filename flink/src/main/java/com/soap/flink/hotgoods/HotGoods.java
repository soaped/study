package com.soap.flink.hotgoods;

import lombok.Data;
import org.apache.flink.api.java.io.PojoCsvInputFormat;
import org.apache.flink.api.java.typeutils.PojoTypeInfo;
import org.apache.flink.api.java.typeutils.TypeExtractor;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.LocalStreamEnvironment;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.timestamps.AscendingTimestampExtractor;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author yangfuzhao on 2020/9/17.
 */
public class HotGoods {


    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        if(env instanceof LocalStreamEnvironment){
            System.out.println("LocalStreamEnvironment");
        }
        //设置事件发生时间
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        URL url = HotGoods.class.getClassLoader().getResource("UserBehavior.csv");
        Path filePath = Path.fromLocalFile(new File(url.toURI()));

        PojoTypeInfo<UserBehavior> pojoType = (PojoTypeInfo<UserBehavior>) TypeExtractor.createTypeInfo(UserBehavior.class);
        Field[] fields = UserBehavior.class.getFields();
        String[] fieldOrder = new  String[fields.length]; // new String[]{"userId", "itemId", "categoryId", "behavior", "timestamp"};
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            fieldOrder[i] = field.getName();
        }
        PojoCsvInputFormat<UserBehavior> csvInput = new PojoCsvInputFormat<>(filePath, pojoType,fieldOrder);

        DataStream<UserBehavior> dataStream = env.createInput(csvInput, pojoType);

        dataStream.assignTimestampsAndWatermarks(new AscendingTimestampExtractor<UserBehavior>() {
            @Override
            public long extractAscendingTimestamp(UserBehavior userBehavior) {
                return userBehavior.timestamp * 1000;
            }
        }).print("$$$$");

        env.execute("HotGoods");
    }


    @Data
    public static class UserBehavior {
        public long userId;         // 用户ID
        public long itemId;         // 商品ID
        public int categoryId;      // 商品类目ID
        public String behavior;     // 用户行为, 包括("pv", "buy", "cart", "fav")
        public long timestamp;      // 行为发生的时间戳，单位秒
    }
}

