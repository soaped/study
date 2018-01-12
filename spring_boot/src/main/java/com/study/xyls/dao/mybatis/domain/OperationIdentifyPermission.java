package com.study.xyls.dao.mybatis.domain;

public class OperationIdentifyPermission {
    private Integer id;

    private String pmsnName;

    private String pmsnDesc;

    private Integer enable;

    private Integer parentId;

    private Integer ignoreLogin;

    private Integer ignorePermission;

    private Integer permissionLevel;

    private String permissionGroup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPmsnName() {
        return pmsnName;
    }

    public void setPmsnName(String pmsnName) {
        this.pmsnName = pmsnName;
    }

    public String getPmsnDesc() {
        return pmsnDesc;
    }

    public void setPmsnDesc(String pmsnDesc) {
        this.pmsnDesc = pmsnDesc;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getIgnoreLogin() {
        return ignoreLogin;
    }

    public void setIgnoreLogin(Integer ignoreLogin) {
        this.ignoreLogin = ignoreLogin;
    }

    public Integer getIgnorePermission() {
        return ignorePermission;
    }

    public void setIgnorePermission(Integer ignorePermission) {
        this.ignorePermission = ignorePermission;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getPermissionGroup() {
        return permissionGroup;
    }

    public void setPermissionGroup(String permissionGroup) {
        this.permissionGroup = permissionGroup;
    }
}