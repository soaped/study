package com.study.xyls.dao.mybatis.domain;

public class OperationIdentifyDepartment {
    private Integer deptCd;

    private String deptNm;

    private Integer brhCd;

    public Integer getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(Integer deptCd) {
        this.deptCd = deptCd;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public Integer getBrhCd() {
        return brhCd;
    }

    public void setBrhCd(Integer brhCd) {
        this.brhCd = brhCd;
    }
}