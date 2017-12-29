package secret;

import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

/**
 * 加密
 *
 */
public   class   Des   
{   
	private static Logger logger = Logger.getLogger(Des.class);
	private Key key;   
  
	private void getKey(String   strKey)   
	{   
		try{   
			KeyGenerator   _generator   =   KeyGenerator.getInstance("DES");   
			_generator.init(new   SecureRandom(strKey.getBytes()));   
			this.key   =   _generator.generateKey();   
			_generator=null;   
		}catch(Exception   e){   
			logger.error(e); 
		}   
	}   

	
	private String getEncString(String   strMing)   
	{   
		byte[]   byteMi   =   null;   
		byte[]   byteMing   =   null;   
		String   strMi   =   "";    
		try   
		{   
			byteMing   =   strMing.getBytes("UTF8");   
			byteMi   =   this.getEncCode(byteMing);   
			strMi   =   new String(org.apache.commons.codec.binary.Base64.encodeBase64(byteMi));
		}   
		catch(Exception   e)   
		{   
			logger.error(e);
		}   
		finally   
		{   
			byteMing   =   null;   
			byteMi   =   null;   
		}   
		return   strMi;   
	}   
   
	private String getDesString(String   strMi)   
	{   
		org.apache.commons.codec.binary.Base64 base64De = new org.apache.commons.codec.binary.Base64();   
		byte[]   byteMing   =   null;   
		byte[]   byteMi   =   null;   
		String   strMing   =   "";   
		try   
		{   
			byteMi   =   base64De.decode(strMi);
			byteMing   =   this.getDesCode(byteMi);   
			strMing   =   new   String(byteMing,   "UTF8");   
		}   
		catch(Exception   e)   
		{   
			logger.error(e);
		}   
		finally   
		{   
			base64De   =   null;   
			byteMing   =   null;   
			byteMi   =   null;   
		}   
		return   strMing;   
	}   

	private byte[] getEncCode(byte[]   byteS)   
	{   
		byte[]   byteFina   =   null;   
		Cipher   cipher;   
		try   
		{   
			cipher   =   Cipher.getInstance("DES");   
			cipher.init(Cipher.ENCRYPT_MODE,   key);   
			byteFina   =   cipher.doFinal(byteS);   
		}   
		catch(Exception   e)   
		{   
			logger.error(e);  
		}   
		finally   
		{   
			cipher   =   null;   
		}   
		return   byteFina;   
}   

	private byte[] getDesCode(byte[]   byteD)   
	{
		Cipher   cipher;   
		byte[]  byteFina=null;   
		try{   
			cipher   =   Cipher.getInstance("DES");   
			cipher.init(Cipher.DECRYPT_MODE,   key);   
			byteFina   =   cipher.doFinal(byteD);   
		}catch(Exception   e){   
			logger.error(e);
		}finally{   
			cipher=null;   
		}   
		return   byteFina;   
	}   
  
	/**
	 * Des算法加密
	 * 
	 * @key 密钥
	 * @s 明文 
	 * @return 密文
	 */
	static String EncryptString(String key,String s){
		Des des = new Des();
		des.getKey(key);
		return des.getEncString(s);
	}
	/**
	 * Des算法解密
	 * 
	 * @key 密钥
	 * @s 密文 
	 * @return 明文
	 */
	static String DecryptionString(String key,String s){
		Des des = new Des();
		des.getKey(key);
		return des.getDesString(s);
	}
	
	
	
	
	
	
} 