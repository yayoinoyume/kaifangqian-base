package com.kaifangqian.modules.system.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.system.vo.SysTenantAppVersionVO;
import lombok.Data;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@TableName("sys_tenant_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
// @ApiModel(value = "sys_tenant_info对象", description = "租户表")
public class SysTenantInfo extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 租户类型 1团体 2个人
     */
    // @ApiModelProperty(value = "租户类型")
    private Integer tenantType;
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
    /**
     * 租户描述
     */
    // @ApiModelProperty(value = "租户描述")
    private String tenantDesc;

    /**
     * 租户邀请码
     */
    // @ApiModelProperty(value = "租户邀请码")
    private String invitationCode;

    private transient List<SysTenantAppVersionVO> apps;
}
