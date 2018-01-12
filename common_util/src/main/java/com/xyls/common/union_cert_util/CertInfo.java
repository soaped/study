package com.xyls.common.union_cert_util;

import java.util.Date;

/**
 * Created by ipaynow0805 on 2017/6/8.
 */
public class CertInfo {

    private Date cerStartTime;//证书开始时间
    private Date cerEndTime;//证书结束时间
    private String publicKey;//公钥串

    public CertInfo(Date cerStartTime, Date cerEndTime, String publicKey) {
        this.cerStartTime = cerStartTime;
        this.cerEndTime = cerEndTime;
        this.publicKey = publicKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Date getCerEndTime() {
        return cerEndTime;
    }

    public void setCerEndTime(Date cerEndTime) {
        this.cerEndTime = cerEndTime;
    }

    public Date getCerStartTime() {
        return cerStartTime;
    }

    public void setCerStartTime(Date cerStartTime) {
        this.cerStartTime = cerStartTime;
    }


    @Override
    public String toString() {
        return "CertInfo{" +
                "cerStartTime=" + cerStartTime +
                ", cerEndTime=" + cerEndTime +
                ", publicKey='" + publicKey + '\'' +
                '}';
    }


}
