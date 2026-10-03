package com.kaifangqian.modules.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
import lombok.Data;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@TableName("sys_tenant_user")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
// @ApiModel(value = "sys_tenant_user对象", description = "租户用户关系表")
public class SysTenantUser extends BaseEntity implements Serializable {
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
     * 用户别称
     */
    // @ApiModelProperty(value = "用户别称")
    private String nickName;

    /**
     * 状态
     */
    // @ApiModelProperty(value = "状态：-2:用户申请加入,-1用户拒绝加入，0:不可用未激活,1:可用激活，2:停用")
    private Integer status;
    /**
     * 添加类型（用户申请，系统自动添加等）
     */
    // @ApiModelProperty(value = "添加类型（用户申请，系统自动添加等）")
    private String addType;

    private String email;
}
