package com.xyls.common_util.reflect;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Administrator on 2017/6/21.
 *
 *
 *
 * org.apache.commons.beanutils.BeanUtils.populate(record,subMap);
 * 的时候将Date映射为String
 */
public class DateConverter implements Converter {

    public Object convert(Class type, Object value){
        if(value == null){
            return null;
        }else if(type == Date.class){
            return convertToDate(type, value, "yyyy-MM-dd HH:mm:ss");
        }else if(type == String.class){
            return convertToString(type, value);
        }

        throw new ConversionException("不能转换 " + value.getClass().getName() + " 为 " + type.getName());
    }

    protected Object convertToDate(Class type, Object value, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        if(value instanceof String){
            try{
                if(StringUtils.isEmpty(value.toString())){
                    return null;
                }
                Date date = sdf.parse((String) value);
                return date;
            }catch(Exception pe){
                return null;
            }
        }else if(value instanceof Date){
            return value;
        }

        throw new ConversionException("不能转换 " + value.getClass().getName() + " 为 " + type.getName());
    }

    protected Object convertToString(Class type, Object value) {
        if(value instanceof Date){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                return sdf.format(value);
            }catch(Exception e){
                throw new ConversionException("日期转换为字符串时出错！");
            }
        }else{
            return value.toString();
        }
    }
}