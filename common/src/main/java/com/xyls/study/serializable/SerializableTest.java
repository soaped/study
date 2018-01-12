package com.xyls.study.serializable;

import java.io.*;
import java.util.List;

/**
 * Created by ipaynow0929 on 2017/12/19.
 */
public class SerializableTest {

    public static void main(String[] args) {
        //output();
        long start =  System.currentTimeMillis();
        input();
        System.out.println("java 序列化时间:" + (System.currentTimeMillis() - start) + " ms" );
    }

    private static void output() {
        try {
            FileOutputStream fos = new FileOutputStream("D:\\ipaynow\\study\\common_util\\src\\main\\java\\com\\yangfuzhao\\study\\serializable\\test.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            Person p1 = new Person.Builder().name("中华人民共和国").age(18).build();
            oos.writeObject(KryoTest.genPer(100));
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }


    private static void input(){
        try {
            FileInputStream fis = new FileInputStream("D:\\ipaynow\\study\\common_util\\src\\main\\java\\com\\yangfuzhao\\study\\serializable\\test.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List p = (List) ois.readObject();
            System.out.print(p.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
    
}
