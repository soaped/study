package com.xyls.mybatus_plugin;

import com.xyls.common.bytes.BytesUtil;
import com.xyls.common.secret.SecretUtil;
import com.xyls.common.secret.encrypt.RSAEncrypt;
import com.xyls.common.secret.encrypt.RsaKeyUtil;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.defaults.DefaultSqlSession;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.*;
/**
 * Created by ipaynow0712 on 2016/9/26.
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class EncryptInterceptor implements Interceptor {

    private static final String METHOD_TYPE_ENCRYPT = "encrypt";

    private static final String METHOD_TYPE_DECRYPT = "decrypt";

    private Map<String, List<String>> map = new HashMap<>();

    private String[] passwords;


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement statement = (MappedStatement) invocation.getArgs()[0];
        String methodName = invocation.getMethod().getName();
        Object parameter = invocation.getArgs()[1];

        //入库加密
        if (methodName.equals("update")) {
            try {
                encryptOrdecryptObject(parameter, METHOD_TYPE_ENCRYPT);
                return invocation.proceed();
            } finally {
                encryptOrdecryptObject(parameter, METHOD_TYPE_DECRYPT);
            }
        }
        //出库解密
        Object result = invocation.proceed();
        encryptOrdecryptObject(result,METHOD_TYPE_DECRYPT);

        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }



    public static final String PRIVATEKEYSTR = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIacOnzq4HcJcSVkIQqMVTTkS3MK\n" +
            "mpwVgk5VUWYCIQ3+ZPutDlo5TRDl07fy3vUC6tKfPI4jCECDH0fnHcbGRxvL2Q5rw0UPknUTVZgF\n" +
            "d+5s5lwJaNsm8jDZK0y4wLbp6E9afegihlqrlVOUG0DoHS/BKAvP+Mr+UlH7qR2N3HMXAgMBAAEC\n" +
            "gYEAg6iifDOuwD73775zosGHRWhVc3vXpPpUrRE9wCws8Gb1lkO5Wf3ZpsFjxvNBpxrnWoJs1Ajn\n" +
            "tVGKcuVWdmjQeq9q/djiG5BSvu2vtNDtGNRtSiOtTAwIM+Av7AKkP3XUqdzoebPOKkDXXhwIcKUf\n" +
            "VDt5UvQ4LLTD3ZgcnMPb5kECQQDHJZre35RgjdpeXRe0CJ6f1XqQwP+LrPtfMMJga1RbppF8M1+k\n" +
            "yYlymT75YKgqSsm4WitvDWS55CDtaZrACjy5AkEArQoMCFg+BWbaksohth4q4GtSOCJ/0xoj+3UJ\n" +
            "RcDnklBgQ6jOs0lTU8jJ8IEyFGQFiLGz6fT2/1YLPioVvZJmTwJBAKKTgpE8OSdx5rluijFBcC3P\n" +
            "25Vc2cIvX69gYO7R8DY6Dz8zuXsPxJO3o392dxK/p1pG0nqAlqBjKrZmphzsvpECQGmxP1RBgfCO\n" +
            "uGb8q8aveoUFSH0dJXJt/xhyji1a/Jc0HPh2vXppCUqd1Crg3xPxXCf4UupORCgGCGv6DLl0GKUC\n" +
            "QEMXQ/o9/s4KEzy+8zswuwozwEBY/bDJiLSeJ5i6qAfn7KduWVNJ6j7FRP1ZXEw33I28SfBk1a9d\n" +
            "/C+n41crQ80=";

    @Override
    public void setProperties(Properties properties) {
        String entityNames = properties.getProperty("entityName");
        String[] entityNameArray = entityNames.split(",");
        String[] attributeValues = properties.getProperty("attributes").split(",");
        //解密
        try {
            RSAPrivateKey privateKey = RsaKeyUtil.string2privateKey(PRIVATEKEYSTR);
            String p = properties.getProperty("passwords");
            byte[] plainText = new RSAEncrypt().decrypt(privateKey,  BytesUtil.hex2bytes(p));
            passwords = new String(plainText).split(",");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }


        for (String entityName : entityNameArray) {
            List<String> list = new ArrayList<>();

            for (String attribute : attributeValues) {
                if(entityName.equals(attribute.split(":")[0])){
                    list.add(attribute.split(":")[1]);
                }
            }
            map.put(entityName, list);
        }

    }

    private void encryptOrdecryptObject(Object object ,String methodType) throws Throwable{
        if (object.getClass().getSimpleName().equals("ArrayList")) {
            List list = (ArrayList) object;
            for (Object obj : list) {
                encryptOrdecryptAttribute(obj, methodType);
            }
        } else if(object.getClass().getSimpleName().equals("StrictMap")) {
            DefaultSqlSession.StrictMap temp = (DefaultSqlSession.StrictMap) object;
            Iterator iter = temp.keySet().iterator();
            while(iter.hasNext()) {
                Object key = iter.next();
                Object value = temp.get(key);
                if (value.getClass().getSimpleName().equals("ArrayList")) {
                    List list = (ArrayList) value;
                    for (Object obj : list) {
                        encryptOrdecryptAttribute(obj, methodType);
                    }
                }
            }

        } else if(object.getClass().getSimpleName().equals("ParamMap")){
            MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap) object;
            encryptOrdecryptAttribute(paramMap.get("record"), methodType);
        }
        else {
            encryptOrdecryptAttribute(object, methodType);
        }
    }


    private void encryptOrdecryptAttribute(Object object, String methodType) throws Throwable {
        if (map.containsKey(object.getClass().getSimpleName())) {
            for (String attributeName : map.get(object.getClass().getSimpleName())) {
                Field field = object.getClass().getDeclaredField(attributeName);
                field.setAccessible(true);
                Object value = field.get(object);
                if(value == null || StringUtils.isEmpty(value.toString())){
                    continue;
                }
                Method method = object.getClass().getMethod("set" + toUpperFirst(attributeName), String.class);
                if (METHOD_TYPE_ENCRYPT.equals(methodType)) {
                    method.invoke(object, SecretUtil.encryptStringAES(value.toString(), passwords[passwords.length-1]));
                } else {
                    if(value.toString().length() % 16 == 0){
                        String arg = null;
                        for(String password : passwords){
                            arg = SecretUtil.decryptStringAES(value.toString(), password);
                            if(arg != null){
                                break;
                            }
                        }
                        if(arg == null) arg = value.toString();// 如果所有的密码都解密失败,使用原值(登录密码二次加密)
                        method.invoke(object, arg);
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




    public static void main(String [] args) throws Exception {
        RSAPublicKey publicKey = null;
        String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCGnDp86uB3CXElZCEKjFU05EtzCpqcFYJOVVFm\n" +
                "AiEN/mT7rQ5aOU0Q5dO38t71AurSnzyOIwhAgx9H5x3Gxkcby9kOa8NFD5J1E1WYBXfubOZcCWjb\n" +
                "JvIw2StMuMC26ehPWn3oIoZaq5VTlBtA6B0vwSgLz/jK/lJR+6kdjdxzFwIDAQAB";
        publicKey = RsaKeyUtil.string2publicKey(publicKeyStr);

        //测试字符串
        String encryptStr= "password";
        //加密
        byte[] cipher = new RSAEncrypt().encrypt(publicKey, encryptStr.getBytes());
        System.out.println("加密结果 : " + BytesUtil.bytes2hex(cipher));
    }
}
