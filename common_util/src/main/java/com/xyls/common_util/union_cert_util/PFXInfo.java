package com.xyls.common_util.union_cert_util;

import java.util.Date;

/**
 * Created by ipaynow0805 on 2017/6/8.
 */
public class PFXInfo {

    private Date cerStartTime;//证书开始时间
    private Date cerEndTime;//证书结束时间

    private String privateKey;//私钥串
    private String certId;//证书id

    public PFXInfo(Date cerStartTime, Date cerEndTime, String privateKey, String certId) {
        this.cerStartTime = cerStartTime;
        this.cerEndTime = cerEndTime;
        this.privateKey = privateKey;
        this.certId = certId;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public Date getCerStartTime() {
        return cerStartTime;
    }

    public void setCerStartTime(Date cerStartTime) {
        this.cerStartTime = cerStartTime;
    }

    public Date getCerEndTime() {
        return cerEndTime;
    }

    public void setCerEndTime(Date cerEndTime) {
        this.cerEndTime = cerEndTime;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }


    @Override
    public String toString() {
        return "PFXInfo{" +
                "cerStartTime=" + cerStartTime +
                ", cerEndTime=" + cerEndTime +
                ", privateKey='" + privateKey + '\'' +
                ", certId='" + certId + '\'' +
                '}';
    }
}
