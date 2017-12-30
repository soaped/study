package com.yangfuzhao.common.union_cert_util;


import org.apache.commons.net.util.Base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * Created by ipaynow0805 on 2017/6/8.
 */
public class CertUtil {


    public static X509Certificate initCert(String path) {

        X509Certificate encryptCertTemp = null;

        CertificateFactory cf = null;
        FileInputStream in = null;
        try {
            cf = CertificateFactory.getInstance("X.509");
            in = new FileInputStream(path);
            encryptCertTemp = (X509Certificate) cf.generateCertificate(in);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException var14) {
                    var14.printStackTrace();
                }
            }
        }

        return encryptCertTemp;

    }

    public static X509Certificate initCert(InputStream inputStream) {
        X509Certificate encryptCertTemp = null;
        CertificateFactory cf = null;
        try {
            cf = CertificateFactory.getInstance("X.509");
            encryptCertTemp = (X509Certificate) cf.generateCertificate(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException var14) {
                    var14.printStackTrace();
                }
            }
        }
        return encryptCertTemp;
    }

    public static String getCertPublicKey(InputStream inputStream) {
        X509Certificate encryptCertTemp = initCert(inputStream);
        CertInfo certInfo = new CertInfo(encryptCertTemp.getNotBefore(), encryptCertTemp.getNotAfter(),
                Base64.encodeBase64String(encryptCertTemp.getPublicKey().getEncoded()));
        return  certInfo.getPublicKey();
    }


    public static void main(String[] args) {

        X509Certificate cer = initCert("C:\\Users\\ipaynow0929\\Desktop\\ipaynow\\现在支付下载文档\\银联\\acp20151027.cer");

        CertInfo certInfo = new CertInfo(cer.getNotBefore(), cer.getNotAfter(),
                Base64.encodeBase64String(cer.getPublicKey().getEncoded()));

        System.out.println(certInfo.getPublicKey());


    }
}
