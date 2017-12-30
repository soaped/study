package com.yangfuzhao.mybatus_plugin;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;                          ;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.defaults.DefaultSqlSession;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
//        @Signature(type = Executor.class, method = "insert", args = {MappedStatement.class, Object.class})
})
public class DataOverLengthInterceptor implements Interceptor {

    private Map<String, List<String>> map = new HashMap<>();

    private Integer maxLength;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object parameter = invocation.getArgs()[1];
        subSequenceObject(parameter);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }


    @Override
    public void setProperties(Properties properties) {
        String entityNames = properties.getProperty("entityName");
        String[] entityNameArray = entityNames.split(",");
        String[] attributeValues = properties.getProperty("attributes").split(",");
        for (String entityName : entityNameArray) {
            List<String> list = new ArrayList<>();
            for (String attribute : attributeValues) {
                if (entityName.equals(attribute.split(":")[0])) {
                    list.add(attribute.split(":")[1]);
                }
            }
            map.put(entityName, list);
        }
        maxLength = Integer.valueOf(properties.getProperty("maxLength"));
    }

    private void subSequenceObject(Object object) throws Throwable {
        if (object.getClass().getSimpleName().equals("ArrayList")) {
            List list = (ArrayList) object;
            for (Object obj : list) {
                subSequenceString(obj);
            }
        } else if (object.getClass().getSimpleName().equals("StrictMap")) {
            DefaultSqlSession.StrictMap temp = (DefaultSqlSession.StrictMap) object;
            Iterator iter = temp.keySet().iterator();
            while (iter.hasNext()) {
                Object key = iter.next();
                Object value = temp.get(key);
                if (value.getClass().getSimpleName().equals("ArrayList")) {
                    List list = (ArrayList) value;
                    for (Object obj : list) {
                        subSequenceString(obj);
                    }
                }
            }
        } else if (object.getClass().getSimpleName().equals("ParamMap")) {
            MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap) object;
            subSequenceString(paramMap.get("record"));
        } else {
            subSequenceString(object);
        }
    }

    private void subSequenceString(Object object) throws Throwable {
        if (map.containsKey(object.getClass().getSimpleName())) {
            for (String attributeName : map.get(object.getClass().getSimpleName())) {
                Field field = object.getClass().getDeclaredField(attributeName);
                field.setAccessible(true);
                Object value = field.get(object);
                if (value != null && value instanceof String) {
                    String tmp = (String) value;
                    if (tmp != null && tmp.length() > 0 && tmp.length() > maxLength) {
                        Method method = object.getClass().getMethod("set" + toUpperFirst(attributeName), String.class);
                        tmp = tmp.substring(0, maxLength - 6) + "......";
                        method.invoke(object, tmp);
                    }
                }
            }
        }
    }

    private String toUpperFirst(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

}
