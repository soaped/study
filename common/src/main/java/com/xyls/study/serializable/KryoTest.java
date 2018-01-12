package com.xyls.study.serializable;

import com.esotericsoftware.kryo.Kryo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ipaynow0929 on 2017/12/19.
 */
public class KryoTest {

    static Kryo kryo = new Kryo();

    public static void main(String[] args) {
        long start =  System.currentTimeMillis();
        unserialize();
        System.out.println("Kryo 序列化时间:" + (System.currentTimeMillis() - start) + " ms" );
    }

    private static void serialize() {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("D:\\ipaynow\\study\\common_util\\src\\main\\java\\com\\yangfuzhao\\study\\serializable\\kryo.obj");
            com.esotericsoftware.kryo.io.Output objectOutput = new com.esotericsoftware.kryo.io.Output(fileOut);
            kryo.writeObject(objectOutput, genPer(100)  );
            objectOutput.close();
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List genPer(int num){
        List ps = new ArrayList();
        for (int i = 0; i <= num;i++ ){
            Person p1 = new Person.Builder().name("中华人民共和国").age(18).build();
            ps.add(p1);
        }
        return ps;
    }

    private static void unserialize() {
        try {
            FileInputStream fis =
                    new FileInputStream("D:\\ipaynow\\study\\common_util\\src\\main\\java\\com\\yangfuzhao\\study\\serializable\\kryo.obj");
            com.esotericsoftware.kryo.io.Input objectOutput = new com.esotericsoftware.kryo.io.Input(fis);
            List ps = kryo.readObject(objectOutput,ArrayList.class);
            objectOutput.close();
            fis.close();
            System.out.print(ps);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
