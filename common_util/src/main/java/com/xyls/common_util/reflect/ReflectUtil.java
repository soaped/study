package com.xyls.common_util.reflect;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtil {

    public static String getReturnTypePrimitiveContent(Method method, Object obj) {

        if (method.getReturnType().isPrimitive())
            return String.valueOf(obj);

        if (method.getReturnType().equals(String.class)) {
            return ((String) obj);
        }
        if (method.getReturnType().equals(Integer.class)) {
            return ((Integer) obj).toString();
        }
        if (method.getReturnType().equals(Byte.class)) {
            return ((Byte) obj).toString();
        }
        if (method.getReturnType().equals(Long.class)) {
            return ((Long) obj).toString();
        }
        if (method.getReturnType().equals(Double.class)) {
            return ((Double) obj).toString();
        }
        if (method.getReturnType().equals(Float.class)) {
            return ((Float) obj).toString();
        }
        if (method.getReturnType().equals(Character.class)) {
            return ((Character) obj).toString();
        }
        if (method.getReturnType().equals(Short.class)) {
            return ((Short) obj).toString();
        }
        if (method.getReturnType().equals(java.math.BigDecimal.class)) {
            return ((java.math.BigDecimal) obj).toString();
        }
        if (method.getReturnType().equals(java.math.BigInteger.class)) {
            return ((java.math.BigInteger) obj).toString();
        }
        if (method.getReturnType().equals(Boolean.class)) {
            return ((Boolean) obj).toString();
        }
        if (method.getReturnType().equals(java.util.Date.class)) {
            return ((java.util.Date) obj).toString();
        }
        return null;
    }


    private static final String RESOURCE_PATTERN = "/**/*.class";

    private static ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

    /**
     * @param basePackage     如  "com/ipaynow/app_biz_center/plugins/*"
     * @param AnnotationClass 如 ParamsMode.class
     * @return 能够匹配注解的Class
     */
    public static List<Class<?>> getClassByBasePackageAnnotationClass(String basePackage, Class<? extends Annotation> AnnotationClass) {
        List<Class<?>> list = new ArrayList<>();
        try {
            String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(basePackage) + RESOURCE_PATTERN;
            Resource[] resources = resourcePatternResolver.getResources(pattern);
            MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
            for (Resource resource : resources) {
                if (resource.isReadable()) {
                    MetadataReader reader = readerFactory.getMetadataReader(resource);
                    String className = reader.getClassMetadata().getClassName();
                    Class<?> clazz = Class.forName(className);

                    if (AnnotationClass == null) {
                        list.add(clazz);
                    } else {
                        if (null != clazz.getAnnotation(AnnotationClass)) {
                            list.add(clazz);
                        }
                    }

//                    for(Method method : clazz.getMethods()){
//                        if(null != method.getAnnotation(AnnotationClass)){
//
//                            System.out.println(method.toString());
//                        }
//                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

}
