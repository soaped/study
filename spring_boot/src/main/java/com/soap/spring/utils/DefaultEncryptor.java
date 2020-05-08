package com.soap.spring.utils;

import org.jasypt.encryption.StringEncryptor;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by soap on 2017/9/26.
 */
public class DefaultEncryptor implements StringEncryptor {
    @Override
    public String encrypt(String s) {
        return encrypt(s, "xgzm");
    }

    @Override
    public String decrypt(String s) {
        return decrypt(s, "xgzm");
    }

  /*  public static void main(String[] args) {
        encrypt("ipaynow", "xgzm");
    }*/

    public static String encrypt(String content, String password) {

        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");

            byte[] byteContent = content.getBytes("UTF-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(byteContent);
            return bytes2hex(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String content, String password) {

        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //		   kgen.init(128, new SecureRandom(password.getBytes()));
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kgen.init(128, random);

            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();

            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(hex2bytes(content));
            return new String(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
//			  e.printStackTrace();
        } catch (BadPaddingException e) {
//			  e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] hex2bytes(String hexStr) {
        if (hexStr.length() % 2 != 0) {
            hexStr = "0" + hexStr;
        }
        byte[] retByte = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            byte[] b = new byte[1];
            b[0] = intToBytes4(Integer.parseInt(hexStr.substring(2 * i, 2 * i + 2), 16))[3];
            retByte[i] = intToBytes4(Integer.parseInt(hexStr.substring(2 * i, 2 * i + 2), 16))[3];
        }
        return retByte;
    }

    public static String bytes2hex(byte[] bs) {
        String retStr = "";
        for (int i = 0; i < bs.length; i++) {
            if (Integer.toHexString((int) bs[i]).length() > 1) {
                retStr += Integer.toHexString((int) bs[i]).substring(Integer.toHexString((int) bs[i]).length() - 2);
            } else {
                retStr += "0" + Integer.toHexString((int) bs[i]).substring(Integer.toHexString((int) bs[i]).length() - 1);
            }
        }
        return retStr;
    }

    public static byte[] intToBytes4(int i) {
        byte mybytes[] = new byte[4];
        mybytes[3] = (byte) (0xff & i);
        mybytes[2] = (byte) ((0xff00 & i) >> 8);
        mybytes[1] = (byte) ((0xff0000 & i) >> 16);
        mybytes[0] = (byte) ((0xff000000 & i) >> 24);
        return mybytes;
    }
}
