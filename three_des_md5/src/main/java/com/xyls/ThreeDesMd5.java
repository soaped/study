package com.xyls;

import com.xyls.cipher.BASE64;
import com.xyls.three_des_md5.cipher.MD5;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: ipaynow0713
 * Date: 16-8-3
 * Time: 下午3:58
 * To change this template use File | Settings | File Templates.
 */
public class ThreeDesMd5 {


    public static void main(String [] args){
        String DESKey = "q94f85md4gfr4k6lsdc75u3k";
        String MD5Key = "45lkjv809354jgflkwdjhfv08w4rtkl2";
        String dataStr = "123哈哈";
        String encrptyData = ThreeDesMd5.encrpty(dataStr, DESKey, MD5Key);
        System.out.println(ThreeDesMd5.decrpty(encrptyData, DESKey, MD5Key));
    }



    public static String encrpty(String dataStr,String DESKey,String MD5Key){
        String threeDesEncrypt = ThreeDESEncryptProvider.encrypt(dataStr,DESKey);
        threeDesEncrypt = BASE64.encode(threeDesEncrypt.getBytes());

        String reqParamsMd5 = null;
        try {
            reqParamsMd5 = MD5.md5(dataStr + MD5Key, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        reqParamsMd5 = BASE64.encode(reqParamsMd5.getBytes());
        return threeDesEncrypt + "|" + reqParamsMd5;
    }


    public static String decrpty(String encrptyString,String DESKey,String MD5Key){

        String [] tmp = encrptyString.split("\\|");
        String threeDesEncrypt = tmp[0];
        String reqParamsMd5From = tmp[1];

        String dateStr = new String(BASE64.decode(threeDesEncrypt));
        dateStr = ThreeDESEncryptProvider.decrypt(dateStr,DESKey);

        String reqParamsMd5 = null;
        try {
            reqParamsMd5 = MD5.md5(dateStr + MD5Key, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        reqParamsMd5 = BASE64.encode(reqParamsMd5.getBytes());

        reqParamsMd5 = StringUtils.strip(reqParamsMd5,"\n");
        reqParamsMd5 = StringUtils.strip(reqParamsMd5,"\r");
        reqParamsMd5From = StringUtils.strip(reqParamsMd5From,"\n");
        reqParamsMd5From = StringUtils.strip(reqParamsMd5From,"\r");
        if(reqParamsMd5.equals(reqParamsMd5From)){
            return dateStr;
        }else{
            return null;
        }
    }
}
