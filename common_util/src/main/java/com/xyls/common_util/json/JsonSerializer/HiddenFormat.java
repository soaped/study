package com.xyls.common_util.json.JsonSerializer;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 自定义脱敏 序列化工具类
 * Created with IntelliJ IDEA.
 * User: benyamin
 * Date: 17-1-10
 * Time: 下午2:21
 * To change this template use File | Settings | File Templates.
 */
public class HiddenFormat extends JsonSerializer<String> {

    private String getHidden(String s) {
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

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(getHidden(s));
    }

    public static void main(String[] args) {
        HiddenFormat h = new HiddenFormat();
        System.out.println(h.getHidden("杨12345678"));
    }
}
