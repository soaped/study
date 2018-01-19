package com.xyls.mybatus_plugin;


import com.xyls.common_util.secret.SecretUtil;

/**
 * Created with IntelliJ IDEA.
 * User: ipaynow0713
 * Date: 16-10-13
 * Time: 上午2:12
 * To change this template use File | Settings | File Templates.
 */
public class 脱敏数据加解密 {


    public static void main(String[] args) {
        //商户中心现网
//        System.out.println(SecretUtil.encryptStringAES("6210810730007492458","password"));
//                                                        //b41108d23924fe044b390a51a09c7fbf
//        System.out.println(SecretUtil.decryptStringAES("e0abe4323602aa7e6ffb0d7d980d6aa4","password"));

        //应用中心
        System.out.println(SecretUtil.decryptStringAES("eea0d3960c8cc507189f1c1c439facec","${encryptKey}"));
//        System.out.println(SecretUtil.encryptStringAES("871905704110801","${encryptKey}"));
    }
}