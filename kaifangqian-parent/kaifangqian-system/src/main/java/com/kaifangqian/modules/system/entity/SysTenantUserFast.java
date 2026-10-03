package com.kaifangqian.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@TableName("sys_tenant_user_fast")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
// @ApiModel(value = "sys_tenant_user_fast对象", description = "租户用户快捷操作表")
public class SysTenantUserFast extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 租户ID
     */
    // @ApiModelProperty(value = "租户ID")
    private String tenantId;
    /**
     * 用户id
     */
    // @ApiModelProperty(value = "用户id")
    private String userId;
    /**
     * 应用ID
     */
    // @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 菜单id
     */
    // @ApiModelProperty(value = "菜单id")
    private String permissionId;
    /**
     * 联合ID
     */
    // @ApiModelProperty(value = "联合ID")
    private String joinId;
}
