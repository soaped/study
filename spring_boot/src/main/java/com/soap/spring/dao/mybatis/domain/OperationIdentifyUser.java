package com.soap.spring.dao.mybatis.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;


/**
 * @author yangfuzhao on 2020/1/19.
 */
@Data
@TableName(value = "operation_identify_user")
public class OperationIdentifyUser {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * usrCd
     */
    @TableField(value = "usr_cd")
    private String usrCd;

    /**
     * usrNm
     */
    @TableField(value = "usr_nm")
    private String usrNm;

    /**
     * usrPwd
     */
    @TableField(value = "usr_pwd")
    private String usrPwd;

    /**
     * usrSex
     */
    @TableField(value = "usr_sex")
    private Integer usrSex;

    /**
     * brhCd
     */
    @TableField(value = "brh_cd")
    private Integer brhCd;

    /**
     * deptCd
     */
    @TableField(value = "dept_cd")
    private Integer deptCd;

    /**
     * expiredDate
     */
    @TableField(value = "expired_date")
    private Date expiredDate;

    /**
     * enable
     */
    @TableField(value = "enable")
    private Integer enable;

    /**
     * usrMob
     */
    @TableField(value = "usr_mob")
    private String usrMob;

    /**
     * usrEmail
     */
    @TableField(value = "usr_email")
    private String usrEmail;

    /**
     * admin
     */
    @TableField(value = "admin")
    private Integer admin;

    /**
     * remark
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * regTime
     */
    @TableField(value = "reg_time")
    private Date regTime;

    /**
     * loginTime
     */
    @TableField(value = "login_time")
    private Date loginTime;

    /**
     * loginTimes
     */
    @TableField(value = "login_times")
    private Integer loginTimes;

    /**
     * initPwd
     */
    @TableField(value = "init_pwd")
    private String initPwd;

    /**
     * lockStatus
     */
    @TableField(value = "lock_status")
    private Integer lockStatus;

    /**
     * lastLockTime
     */
    @TableField(value = "last_lock_time")
    private Date lastLockTime;

    /**
     * openId
     */
    @TableField(value = "open_id")
    private String openId;
}