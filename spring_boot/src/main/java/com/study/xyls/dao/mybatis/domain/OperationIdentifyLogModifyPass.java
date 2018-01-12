package com.study.xyls.dao.mybatis.domain;

import java.util.Date;

public class OperationIdentifyLogModifyPass {
    private Integer id;

    private String usrCd;

    private String usrPwd;

    private Date lstMdDt;

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

    public String getUsrPwd() {
        return usrPwd;
    }

    public void setUsrPwd(String usrPwd) {
        this.usrPwd = usrPwd;
    }

    public Date getLstMdDt() {
        return lstMdDt;
    }

    public void setLstMdDt(Date lstMdDt) {
        this.lstMdDt = lstMdDt;
    }
}