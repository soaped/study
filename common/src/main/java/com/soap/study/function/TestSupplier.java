package com.soap.study.function;

import java.util.Date;
import java.util.function.Supplier;

/**
 * @author yangfuzhao on 2019/11/22.
 */
public class TestSupplier {

    public static void main(String[] args) {
        Supplier supplier = () -> new Date();
        System.out.println(supplier.get());
    }
}
