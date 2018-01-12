package com.xyls.common.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * Created by ipaynow1130 on 2017/5/10.
 */
@Getter
@Setter
@AllArgsConstructor
public class Test {

    private int id;
    @Hidden
    private String name;



    public static void main(String [] args){
        Test test = new Test(1,"aaaaaaaaaaaaaaaaaaaa");
        System.out.println(JSON.toJSONString(test,new ValueFilter(){
            @Override
            public Object process(Object o, String s, Object o1) {
                Field[] fields = o.getClass().getDeclaredFields();
                for(Field field : fields){
                    if(field.getName().equals(s) && field.getAnnotation(Hidden.class) != null && o1 instanceof String){
                        return getHidden((String)o1);
                    }
                }
                return o1;
            }

//        },new SerializerFeature[]{SerializerFeature.PrettyFormat}));
        },new SerializerFeature[]{}));
    }






    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    private @interface Hidden {
    }




    private static String getHidden(String s) {
        if (s == null || s.length() < 8) {
            StringBuilder buff = new StringBuilder();
            if(s.length()==2) {
                return buff.append(s.substring(0,1)).append("*").toString();
            }
            if(s.length()==3) {
                return buff.append(s.substring(0,1)).append("*").append(s.substring(2)).toString();
            }
            if(s.length()==4) {
                return buff.append(s.substring(0,1)).append("**").append(s.substring(3)).toString();
            }
            if(s.length()==5) {
                return buff.append(s.substring(0,2)).append("**").append(s.substring(4)).toString();
            }
            if(s.length()==6) {
                return buff.append(s.substring(0,2)).append("**").append(s.substring(4)).toString();
            }
            if(s.length()==7) {
                return buff.append(s.substring(0,2)).append("***").append(s.substring(5)).toString();
            }
            return s;
        }
        StringBuilder buff = new StringBuilder();
        buff.append(s.substring(0,4)).append("******").append(s.substring(s.length()-4,s.length()));
        return buff.toString();
    }

}
