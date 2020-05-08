package com.soap.study.function;

import java.util.function.Function;

/**
 * @author yangfuzhao on 2019/11/22.
 */
public class TestFunction {

    public static void main(String[] args) {
        Function<Object, String> function = i -> String.valueOf(i);

        System.out.println(function.apply(7));
    }
}
