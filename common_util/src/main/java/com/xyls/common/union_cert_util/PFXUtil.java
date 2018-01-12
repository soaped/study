package com.xyls.common.union_cert_util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class PFXUtil {


    public static void main(String[] args) {

        String certPath = "C:\\Users\\ipaynow0929\\Desktop\\ipaynow\\现在支付下载文档\\银联\\700000000000001_acp.pfx";
        String password = "000000";

        PFXInfo pfxInfo = getPFXFileInfo(certPath, password);
        System.out.println(pfxInfo.toString());

    }


    /**
     * 获取pfx文件信息
     *
     * @param fpxFilePath pfx文件路径
     * @param password    pfx密码
     * @return
     */
    public static PFXInfo getPFXFileInfo(String fpxFilePath, String password) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fpxFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return getPFXFileInfo(fis, password);


    }

    public static PFXInfo getPFXFileInfo(InputStream inputStream, String password) {
        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            char[] nPassword;// If the keystore password is empty(""), then we have to set to null, otherwise it won't work!!!
            if ((password == null) || password.trim().equals("")) {
                nPassword = null;
            } else {
                nPassword = password.toCharArray();
            }

            ks.load(inputStream, nPassword);
            Enumeration keyAliases = ks.aliases();
            String keyAlias = "";
            if (keyAliases.hasMoreElements()) {
                keyAlias = (String) keyAliases.nextElement();
            }
            PrivateKey privateKey = (PrivateKey) ks.getKey(keyAlias, nPassword);
            Certificate cert = ks.getCertificate(keyAlias);

            X509Certificate x509Certificate = (X509Certificate) cert;

            return new PFXInfo(x509Certificate.getNotBefore(), x509Certificate.getNotAfter(),
                    Base64.encode(privateKey.getEncoded()), x509Certificate.getSerialNumber().toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
