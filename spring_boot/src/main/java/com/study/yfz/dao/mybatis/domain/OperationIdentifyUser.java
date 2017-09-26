package com.study.yfz.dao.mybatis.domain;

import java.util.Date;

public class OperationIdentifyUser {
    private Integer id;

    private String usrCd;

    private String usrNm;

    private String usrPwd;

    private Integer usrSex;

    private Integer brhCd;

    private Integer deptCd;

    private Date expiredDate;

    private Integer enable;

    private String usrMob;

    private String usrEmail;

    private Integer admin;

    private String remark;

    private Date regTime;

    private Date loginTime;

    private Integer loginTimes;

    private String initPwd;

    private Integer lockStatus;

    private Date lastLockTime;

    private String openId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsrCd() {
        return usrCd;
    }

    public void setUsrCd(String usrCd) {
        this.usrCd = usrCd;
    }

    public String getUsrNm() {
        return usrNm;
    }

    public void setUsrNm(String usrNm) {
        this.usrNm = usrNm;
    }

    public String getUsrPwd() {
        return usrPwd;
    }

    public void setUsrPwd(String usrPwd) {
        this.usrPwd = usrPwd;
    }

    public Integer getUsrSex() {
        return usrSex;
    }

    public void setUsrSex(Integer usrSex) {
        this.usrSex = usrSex;
    }

    public Integer getBrhCd() {
        return brhCd;
    }

    public void setBrhCd(Integer brhCd) {
        this.brhCd = brhCd;
    }

    public Integer getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(Integer deptCd) {
        this.deptCd = deptCd;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getUsrMob() {
        return usrMob;
    }

    public void setUsrMob(String usrMob) {
        this.usrMob = usrMob;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    public String getInitPwd() {
        return initPwd;
    }

    public void setInitPwd(String initPwd) {
        this.initPwd = initPwd;
    }

    public Integer getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

    public Date getLastLockTime() {
        return lastLockTime;
    }

    public void setLastLockTime(Date lastLockTime) {
        this.lastLockTime = lastLockTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}