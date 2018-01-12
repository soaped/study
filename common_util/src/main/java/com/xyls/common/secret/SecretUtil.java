package com.xyls.common.secret;

import com.xyls.common.bytes.BytesUtil;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


public class SecretUtil {

	
	 public static String base64Encode ( String s ){
		 return Base64.base64Encode(s);
	 }
    public static String base64Encode ( byte[] bytes ){
        return Base64.base64Encode(bytes);
    }
	 public static String base64Decode (String s){
		 return Base64.base64Decode(s);
	 }
    public static String base64Decode (byte[] bytes){
        return Base64.base64Decode(bytes);
    }
    public static byte[] base64DecodeBytes (byte[] bytes){
        return Base64.base64DecodeBytes(bytes);
    }
	 public static String EncryptString(String key,String s){
		 return Des.EncryptString(key, s);
	 }
	 public static String DecryptionString(String key,String s){
		 return Des.DecryptionString(key,s);
	 }
	 
	 
	 public static String ToMd5(String s,String encode,String salt){
		 return MD5.ToMd5(s,encode,salt);
	 }
	 public static byte[] ToMd5(byte[] bytes,String salt){
         return MD5.ToMd5(bytes,salt);
     }
	 public static String getFileMD5String(File file,String salt) throws NoSuchAlgorithmException, IOException{
		 return MD5.getFileMD5String(file,salt);
	 }
	 
	 public static String Sha1Encode(String s){
		 return SHA1.encode(s);
	 }
	 
	 public static String encryptStringAES(String s,String pass){
	     return AES.encrypt(s, pass);
	 }
	 public static String decryptStringAES(String s,String pass){
         return AES.decrypt(s, pass);
     }

    public static byte[] Union3DesEncrypt(byte[] key, byte[] data) {
        return Union3DesUtils.Union3DesEncrypt(key,data);
    }

    public static byte[] Union3DesDecrypt(byte[] key, byte[] data) {
        return Union3DesUtils.Union3DesDecrypt(key, data);
    }






    /**
     * 3des base64 解密
     * 3DES(base64(报文密文))
     * @param key
     * @param data
     * @return
     */
    public static String decryptBase64UnionDes(String key,String data) {
        String result = null;
        byte[] base64Byte = new org.apache.commons.codec.binary.Base64().decode(data.getBytes());
        try {
            result =  new String(SecretUtil.Union3DesDecrypt(key.getBytes(), base64Byte));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * base64 3des 加密
     * base64(3DES(报文原文)
     * @param key
     * @param data
     * @return
     */
    public static String encryptUnionDesBase64(String key,String data) {
        String result = null;
        byte[] b  =  SecretUtil.Union3DesEncrypt(key.getBytes(), data.getBytes());
        try {
            result = new String(new org.apache.commons.codec.binary.Base64().encode(b),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 生成AES秘钥
     * @param bits 128/192/256
     */
    public static String generatorAesKey(int bits){
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);//要生成多少位，只需要修改这里即可128, 192或256
            SecretKey sk = kg.generateKey();
            byte[] b = sk.getEncoded();
            return BytesUtil.bytes2hex(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String [] args){
        System.out.println(SecretUtil.ToMd5("99999qwe123!@#","UTF-8",null).substring(16));
    }
}
