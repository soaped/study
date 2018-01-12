package com.study.yfz.dao.mybatis.domain;

public class OperationIdentifyRole {
    private Integer id;

    private String roleName;

    private String roleDesc;

    private Integer crtUserId;

    private Integer enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getCrtUserId() {
        return crtUserId;
    }

    public void setCrtUserId(Integer crtUserId) {
        this.crtUserId = crtUserId;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}