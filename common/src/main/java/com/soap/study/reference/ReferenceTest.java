package com.soap.study.reference;

import java.lang.ref.SoftReference;

/**
 * Created by ipaynow0929 on 2017/12/20.
 */
public class ReferenceTest {

    //-Xmx1m -Xms1m
    public static void main(String[] args) {
        //创建软引用数组
        SoftReference<String> [] p = new SoftReference[19990]; //18990
        //赋值
        for(int i = 0; i< p.length ;i++){
            p[i] = new SoftReference("string");
        }
        //测试
        System.out.println(p[1].get());
        System.out.println(p[4].get());
        //通知系统进行回收
        System.gc();
        //强制回收
        System.runFinalization();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------------");
        System.out.println(p[1].get());
        System.out.println(p[4].get());

        //*** java.lang.instrument ASSERTION FAILED ***: "!errorOutstanding" with message can't create byte arrau at JPLISAgent.c line: 813
    }
}
