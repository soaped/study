package com.xyls;

import com.xyls.cipher.DESUtils;
import com.xyls.cipher.EncodeUtils;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by kingsir on 16-7-29.
 */
public class ThreeDESEncryptProvider {

    public static String encrypt(String data,String key) {
        try {
            return EncodeUtils.byte2HexString(DESUtils.Union3DesEncrypt(key.getBytes("utf-8"), Base64.encodeBase64(data.getBytes("utf-8"))));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String decrypt(String data,String key){
        try {
            return new String(Base64.decodeBase64(DESUtils.Union3DesDecrypt(key.getBytes("utf-8"), EncodeUtils.hexString2Byte(data))), "utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
