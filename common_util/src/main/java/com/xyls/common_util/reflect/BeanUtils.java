package com.xyls.common_util.reflect;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {


	protected static final Log logger = LogFactory.getLog(BeanUtils.class);

	private BeanUtils() {
	}

    public static void map2Bean(Map<String, String> map, Object obj) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(obj, value);
                }
            }
        } catch (Exception e) {
            System.out.println("transMap2Bean Error " + e);
        }

        return;

    }

    /**
	 * 循环向上转型,获取对象的DeclaredField.
	 */
	public static Field getDeclaredField(Object object, String propertyName)
			throws NoSuchFieldException {
		return getDeclaredField(object.getClass(), propertyName);
	}
	private static Field getDeclaredField(Class<?>clazz, String propertyName)
			throws NoSuchFieldException {
		for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredField(propertyName);
			} catch (NoSuchFieldException e) {
				// Field不在当前类继续向上转型
			}
		}
		throw new NoSuchFieldException("No such field: " + clazz.getName() + '.' + propertyName);
	}
	/**
	 * 
	 * 暴力获取对象变量的值,忽略private,protected修饰符的限制.
	 */
	public static Object forceGetProperty(Object object, String propertyName)
			throws NoSuchFieldException {
		Object result = null;
		try {
			result = BeanUtilsBean.getInstance().getPropertyUtils()
					.getProperty(object, propertyName);
			if (result != null) {
				return result;
			}
		} catch (Exception e) {

		}

		Field field = getDeclaredField(object, propertyName);

		boolean accessible = field.isAccessible();
		field.setAccessible(true);

		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			logger.info("error wont' happen");
		}
		field.setAccessible(accessible);
		return result;
	}

	/**
	 * 暴力设置对象变量赋值忽略private,protected修饰符的限制.
	 */
	public static void forceSetProperty(Object object, String propertyName,
			Object newValue) throws NoSuchFieldException {
		try {
			BeanUtilsBean.getInstance().getPropertyUtils()
					.setProperty(object, propertyName, newValue);
			return;
		} catch (Exception e) {
		}

		Field field = getDeclaredField(object, propertyName);
		boolean accessible = field.isAccessible();
		field.setAccessible(true);
		try {
			field.set(object, newValue);
		} catch (IllegalAccessException e) {
			logger.info("Error won't happen");
		}
		field.setAccessible(accessible);
	}

	/**
	 * 暴力调用对象函数,忽略private,protected修饰符的限制.
	 */
	public static Object invokePrivateMethod(Object object, String methodName,
			Object... params) throws NoSuchMethodException {
		Class<?>[] types = new Class[params.length];
		for (int i = 0; i < params.length; i++) {
			types[i] = params[i].getClass();
		}

		Class<?> clazz = object.getClass();
		Method method = null;
		for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				method = superClass.getDeclaredMethod(methodName, types);
				break;
			} catch (NoSuchMethodException e) {
				// 方法不在当前类定�?继续向上转型
			}
		}

		if (method == null)
			throw new NoSuchMethodException("No Such Method:"
					+ clazz.getSimpleName() +" "+ methodName);

		boolean accessible = method.isAccessible();
		method.setAccessible(true);
		Object result = null;
		try {
			result = method.invoke(object, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		method.setAccessible(accessible);
		return result;
	}

	/**
	 * <p>
	 * 按Filed的类型取得Field列表.
	 * </p>
	 */
	public static List<Field> getFieldsByType(Object object, Class<?> type) {
		List<Field> list = new ArrayList<Field>();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.getType().isAssignableFrom(type)) {
				list.add(field);
			}
		}
		return list;
	}

	/**
	 * <p>
	 * 按FiledName获得Field的类
	 * </p>
	 */
	public static Class<?> getPropertyType(Class<?> type, String name)
			throws NoSuchFieldException {
		return getDeclaredField(type, name).getType();
	}

	/**
	 * <p>
	 * 获得field的getter函数名称.
	 * </p>
	 */
	public static String getGetterName(Class<?> type, String fieldName) {

		if (type.getName().equals("boolean")) {
			return "is" + StringUtils.capitalize(fieldName);
		} else {
			return "get" + StringUtils.capitalize(fieldName);
		}
	}

	/**
	 * <p>
	 * 获得field的getter函数,如果找不到该方法,返回null.
	 * </p>
	 */
	public static Method getGetterMethod(Class<?> type, String fieldName) {
		try {
			return type.getMethod(getGetterName(type, fieldName));
		} catch (NoSuchMethodException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * pojo方式
	 * @param object
	 * @return
	 */
	public static String toString(Object object) {
		StringBuffer sb = new StringBuffer();
		Method methods[] = object.getClass().getMethods();
		sb.append("*******").append(object.getClass().getName()).append(
				"\tAttibutes Begin************\n");
		Method arr[] = methods;
		int len = arr.length;
		for (int i = 0; i< len; i++) {
			Method getter = arr[i];
			if (getter.getName().startsWith("get")
					&& getter.getName().length() > 3
					&& getter.getParameterTypes().length == 0
					&& !getter.getName().equals("getClass")) {
				String name = (new StringBuilder()).append(
						Character.toUpperCase(getter.getName().charAt(3)))
						.append(getter.getName().substring(4)).toString();
				Object value = invoke(getter, object, null);
				sb.append(name).append(" = ").append(value).append("\n");
			}
		}

		sb.append("*******").append(object.getClass().getName()).append(
				"\tAttibutes End************\n");
		return sb.toString();
	}
	
	
	private static Object invoke(Method setter, Object bean, Object value) {
		try {
			if(value ==null){
				return setter.invoke(bean, (Object[])null);
			}
			return setter.invoke(bean, new Object[] { value });
		} catch (IllegalArgumentException ex) {
			logger.error("- Internal error: " + ex.getMessage()); //$NON-NLS-1$
		} catch (IllegalAccessException ex) {
			logger.error("- Permission error: " + ex.getMessage()); //$NON-NLS-1$
		} catch (InvocationTargetException ex) {
			logger.error("- Exception during auto-wire: ", ex.getTargetException()); //$NON-NLS-1$
		}
		return null;
	}
}
