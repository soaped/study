package com.xyls.common.secret;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.spec.KeySpec;

public class Union3DesUtils {

    /**
     * 3des加密
     *
     * @param key  密钥
     * @param data 明文数据 16进制且长度为16的整数倍不足时补0
     * @return 密文数据
     */
    static byte[] Union3DesEncrypt(byte[] key, byte[] data) {
        try {
            byte[] k = new byte[24];
            if (key.length == 16) {
                System.arraycopy(key, 0, k, 0, key.length);
                System.arraycopy(key, 0, k, 16, 8);
            } else {
                System.arraycopy(key, 0, k, 0, 24);
            }
            byte[] buff = complementZero(data);
            KeySpec ks = new DESedeKeySpec(k);
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DESede");
            SecretKey ky = kf.generateSecret(ks);
            Cipher c = Cipher.getInstance("DESede/ECB/NoPadding");
            c.init(Cipher.ENCRYPT_MODE, ky);
            return c.doFinal(buff);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 3des解密
     *
     * @param key  密钥
     * @param data 密文数据 16进制且长度为16的整数倍
     * @return 明文数据
     */
    static byte[] Union3DesDecrypt(byte[] key, byte[] data) {
        try {
            byte[] k = new byte[24];
            if (key.length == 16) {
                System.arraycopy(key, 0, k, 0, key.length);
                System.arraycopy(key, 0, k, 16, 8);
            } else {
                System.arraycopy(key, 0, k, 0, 24);
            }
            KeySpec ks = new DESedeKeySpec(k);
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DESede");
            SecretKey ky = kf.generateSecret(ks);
            Cipher c = Cipher.getInstance("DESede/ECB/NoPadding");
            c.init(Cipher.DECRYPT_MODE, ky);
            return c.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }




    public static void main(String[] args) {
        byte[] str1 = "123哈哈".getBytes();
        byte[] key = "1234567890123456".getBytes();
        System.out.println(new String(Union3DesDecrypt(key,Union3DesEncrypt(key,str1))));
    }



    private static byte[] complementZero(byte[] b) {
        int len = b.length;

        //data不足8位以0补足8位
        if (b.length % 8 != 0) {
            len = b.length - b.length % 8 + 8;
        } else {
            return b;
        }
        byte[] needData = null;
        needData = new byte[len];
        for (int i = 0; i < len; i++) {
            needData[i] = 0x00;
        }
        System.arraycopy(b, 0, needData, 0, b.length);
        return needData;
    }
}
