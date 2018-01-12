package com.study.xyls.dao.mybatis.domain;

import java.util.Date;

public class OperationIdentifyLogSys {
    private Integer id;

    private String mchId;

    private String operationDetail;

    private Integer moduleId;

    private String userCd;

    private String ip;

    private Date opTime;

    private Integer moduleSubId;

    private String moduleSubDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getOperationDetail() {
        return operationDetail;
    }

    public void setOperationDetail(String operationDetail) {
        this.operationDetail = operationDetail;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getUserCd() {
        return userCd;
    }

    public void setUserCd(String userCd) {
        this.userCd = userCd;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public Integer getModuleSubId() {
        return moduleSubId;
    }

    public void setModuleSubId(Integer moduleSubId) {
        this.moduleSubId = moduleSubId;
    }

    public String getModuleSubDetail() {
        return moduleSubDetail;
    }

    public void setModuleSubDetail(String moduleSubDetail) {
        this.moduleSubDetail = moduleSubDetail;
    }
}