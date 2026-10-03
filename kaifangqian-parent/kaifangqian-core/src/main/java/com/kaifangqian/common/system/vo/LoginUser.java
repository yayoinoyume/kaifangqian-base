/**
 * @description 在线用户信息
 */
package com.kaifangqian.common.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * @author : zhenghuihan
 * create at: 2023/12/26
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoginUser {

    /**
     * 登录人账号id
     */
    private String id;


    /**
     * 当前登录租户Id
     */
    private String tenantId;

    /**
     * 登录人租户-用户Id
     */
    private String tenantUserId;

    /**
     * 登录人账号
     */
    private String username;

    /**
     * 登录人名字
     */
    private String realname;

    /**
     * 登录人密码
     */
    private String password;

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
     * 状态(1：正常 2：冻结 ）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 职务，关联职务表
     */
    private String post;

    /**
     * 座机号
     */
    private String telephone;

    /**
     * 标识功能权限(用户+租户+应用+组织)
     */
    private String userAuthId;

    /**
     * 当前登录应用code
     */
    private String appCode;

    /**
     * 当前登录部门code
     */
    private String orgCode;

    /**
     * 当前登录部门id
     */
    private String departId;

    /**
     * 当前登录用户token
     */
    private String token;
}
