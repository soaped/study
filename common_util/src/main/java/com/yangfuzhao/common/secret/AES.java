package com.yangfuzhao.common.secret;

import com.ipaynow.npacc.common.bytes.BytesUtil;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


/**
 * 加密
 *
 */
public class AES {
    
	 static String encrypt(String content, String password) {
		 
	     try {
    		   KeyGenerator kgen = KeyGenerator.getInstance("AES");	  
    		   SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
    		   random.setSeed(password.getBytes());
    		   kgen.init(128, random);
    		   SecretKey secretKey = kgen.generateKey();	  
    		   byte[] enCodeFormat = secretKey.getEncoded();	  
    		   SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");	  
    		   Cipher cipher = Cipher.getInstance("AES");
    		  
    		   byte[] byteContent = content.getBytes("UTF-8");	  
    		   cipher.init(Cipher.ENCRYPT_MODE, key);
    		   byte[] result = cipher.doFinal(byteContent);
    		   return BytesUtil.bytes2hex(result);
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
		 
	 static String decrypt(String content, String password) {

		  try {  
    		   KeyGenerator kgen = KeyGenerator.getInstance("AES");	  
    //		   kgen.init(128, new SecureRandom(password.getBytes()));
    		   SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
    		   random.setSeed(password.getBytes());
    		   kgen.init(128, random);
    		   	  
    		   SecretKey secretKey = kgen.generateKey();	  
    		   byte[] enCodeFormat = secretKey.getEncoded();
    		   
    		   SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");	  
    		   Cipher cipher = Cipher.getInstance("AES");
    		   cipher.init(Cipher.DECRYPT_MODE, key);
    		   byte[] result = cipher.doFinal(BytesUtil.hex2bytes(content));
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
		  }	 
		  catch (Exception e) {	 
			  e.printStackTrace();	 
		  }	
		  return null;
		 }
}
