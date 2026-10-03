package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/6/27  19:07
 * @description:部门用户信息
 */
@Data
public class SysDepartUserVO {
    private String id;

    private String tenantUserId;

    private String username;

    private String realname;

    private String nickName;

    private String phone;

    private String email;

    private String orgCode;

    /**
     * 状态(0:未激活 1：正常  2：冻结 ）
     */
    private Integer status;

    /**
     * 是否主管
     */
    private Boolean manageFlag;

    private String roleNames;

    private String roleName;

    private Integer count;

    private String type = "user";

    private String addType;

    /**
     * 头像缩略图
     */
    private String avatarBase64;
}