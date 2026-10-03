package com.kaifangqian.modules.system.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2023/10/18  16:51
 * @description:租户信息
 */
@Data
public class SysTenantInfoRes {
    private String id;
    /**
     * 租户名称
     */
    // @ApiModelProperty(value = "租户名称")
    private String tenantName;
    /**
     * 租户状态
     */
    // @ApiModelProperty(value = "租户状态1:启用 2停用")
    private Integer tenantStatus;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @ApiModelProperty(value = "创建日期")
    private Date createTime;


    /**
     * 姓名或企业名称
     */
    @TableField("name")
    private String name;

    /**
     * 身份证号码或单位证件号码
     */
    @TableField("organization_no")
    private String organizationNo;

    /**
     * 法定代表人
     */
    @TableField("corporation")
    private String corporation;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 认证状态：未认证、认证审核中、认证审核失败、认证成功
     */
    @TableField("auth_status")
    private Integer authStatus;

    private String applyUserName;

    private String sysType;

    private transient List<SysTenantAppVersionVO> apps;
}