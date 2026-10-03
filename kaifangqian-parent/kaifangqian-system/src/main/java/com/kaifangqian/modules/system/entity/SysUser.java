package com.kaifangqian.modules.system.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaifangqian.common.base.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @Author zhh
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 密码
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * md5密码盐
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String salt;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 头像缩略图
     */
    private String avatarBase64;

    /**
     * 生日
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 性别（1：男 2：女）
     */
    private Integer sex;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 状态(0:游离 1：正常  2：冻结 3：自动冻结（密码错误））
     */
    private Integer status;


    /**
     * 冻结时间（自动）
     */
    private Date freezeTime;

    /**
     * 工号，唯一键
     */
    private String workNo;

    /**
     * 职务
     */
    private String post;

    /**
     * 座机号
     */
    private String telephone;


    /**
     * 用户类型（游客：visitor）
     */
    private String userType;

    private transient String orgCodeTxt;

    private Date updatePasswordTime;

    private String passwordLevel;

    private Date lastTimeLoadTime;

    private String lastTimeLoadSite;

    /**
     * 上次登录部门
     */
    private String departId;

    private boolean initUserInfo;
}
