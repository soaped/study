package secret.encrypt;



import com.ipaynow.npacc.common.bytes.BytesUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/*
<!-- secret/encrypt/rsa -->
<dependency>
  <groupId>org.bouncycastle</groupId>
  <artifactId>bcprov-jdk16</artifactId>
  <version>1.46</version>
</dependency>
*/
//import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class RSAEncrypt {


    /**
     * 加密过程
     * @param publicKey 公钥
     * @param plainTextData 明文数据
     * @return
     * @throws Exception 加密过程中的异常信息
     */
    public byte[] encrypt(Key publicKey, byte[] plainTextData) throws Exception{
        if(publicKey== null){
            throw new Exception("加密公钥为空, 请设置");
        }
        Cipher cipher= null;
        try {
//            cipher= Cipher.getInstance("RSA");
            cipher= Cipher.getInstance("RSA/ECB/PKCS1Padding");
//            cipher= Cipher.getInstance("RSA", new BouncyCastleProvider());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output= cipher.doFinal(plainTextData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        }catch (InvalidKeyException e) {
            throw new Exception("加密公钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("明文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("明文数据已损坏");
        }
    }

    /**
     * 解密过程
     * @param privateKey 私钥
     * @param cipherData 密文数据
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     */
    public byte[] decrypt(Key privateKey, byte[] cipherData) throws Exception{
        if (privateKey== null){
            throw new Exception("解密私钥为空, 请设置");
        }
        Cipher cipher= null;
        try {
//            cipher= Cipher.getInstance("RSA");
            cipher= Cipher.getInstance("RSA/ECB/PKCS1Padding");
//            cipher= Cipher.getInstance("RSA", new BouncyCastleProvider());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] output= cipher.doFinal(cipherData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        }catch (InvalidKeyException e) {
            throw new Exception("解密私钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("密文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("密文数据已损坏");
        }       
    }


    public static void main(String[] args){
        try {
            RSAPublicKey publicKey = null;
            RSAPrivateKey privateKey = null;
            String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCGnDp86uB3CXElZCEKjFU05EtzCpqcFYJOVVFm\n" +
                    "AiEN/mT7rQ5aOU0Q5dO38t71AurSnzyOIwhAgx9H5x3Gxkcby9kOa8NFD5J1E1WYBXfubOZcCWjb\n" +
                    "JvIw2StMuMC26ehPWn3oIoZaq5VTlBtA6B0vwSgLz/jK/lJR+6kdjdxzFwIDAQAB";
            publicKey = RsaKeyUtil.string2publicKey(publicKeyStr);


            String privateKeyStr = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIacOnzq4HcJcSVkIQqMVTTkS3MK\n" +
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
            privateKey = RsaKeyUtil.string2privateKey(privateKeyStr);

            //测试字符串
            String encryptStr= "${encryptKey},Q290G3SDJNGKNMAK12BDI8B";
            //加密
            byte[] cipher = new RSAEncrypt().encrypt(publicKey, encryptStr.getBytes());
            System.out.println("加密结果 : " + BytesUtil.bytes2hex(cipher));

            //解密
            byte[] plainText = new RSAEncrypt().decrypt(privateKey, cipher);
            System.out.println("解密结果: "+new String(plainText));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    
    
    
    
    
    
    
    
    

}