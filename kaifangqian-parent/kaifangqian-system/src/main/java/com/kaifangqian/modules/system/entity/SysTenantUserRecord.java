package com.kaifangqian.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_tenant_user_record")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
// @ApiModel(value = "sys_tenant_user_record", description = "租户用户申请表")
public class SysTenantUserRecord extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty(value = "主键")
    private String id;
    // @ApiModelProperty(value = "账号ID")
    private String userId;
    /**
     * 租户ID
     */
    // @ApiModelProperty(value = "租户ID")
    private String tenantId;
    /**
     * 用户id
     */
    // @ApiModelProperty(value = "用户id")
    private String tenantUserId;
    /**
     * 用户别称
     */
    // @ApiModelProperty(value = "用户别称")
    private String nickName;
    // @ApiModelProperty(value = "手机")
    private String phone;
    // @ApiModelProperty(value = "邮箱")
    private String email;
    // @ApiModelProperty("申请时间")
    @JsonFormat(
            timezone = "GMT+8",
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date applyTime;
    /**
     * 状态
     */
    // @ApiModelProperty(value = "状态0待审核，1已通过 2未通过")
    private Integer status;
    // @ApiModelProperty(value = "审核人")
    private String checkTenantUserId;
    // @ApiModelProperty("审核时间")
    @JsonFormat(
            timezone = "GMT+8",
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date checkTime;

    private transient String checkTenantUserName;
}
