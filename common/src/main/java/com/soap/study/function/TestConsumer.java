package com.soap.study.function;


import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.ObjLongConsumer;

/**
 * @author yangfuzhao on 2019/11/22.
 */
public class TestConsumer {

    public static void main(String[] args) {
        Consumer consumer = i -> System.out.println(i);

        consumer.accept(10);


        LongConsumer longConsumer = i -> {
            System.out.println(i + "是否偶数：" + (i % 2 == 0));
        };

        longConsumer.accept(3);
        longConsumer.accept(4);


        ObjLongConsumer objLongConsumer = (obj, i) -> System.out.println(obj + ":" + i);

        objLongConsumer.accept("a", 2);

        BiConsumer biConsumer = (a, b) -> System.out.println(a + " : " + b);
        biConsumer.accept("来","Come");

    }

}
