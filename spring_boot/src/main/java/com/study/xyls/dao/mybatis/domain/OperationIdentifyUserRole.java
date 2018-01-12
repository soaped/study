package com.study.yfz.dao.mybatis.domain;

public class OperationIdentifyUserRole {
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private Integer operationUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(Integer operationUserId) {
        this.operationUserId = operationUserId;
    }
}