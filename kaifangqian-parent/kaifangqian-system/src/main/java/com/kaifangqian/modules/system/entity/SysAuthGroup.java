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

/**
 * @author zhenghuihan
 * @description 权限组表
 * @createTime 2022/9/2 18:07
 */
@Data
@TableName("sys_auth_group")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
// @ApiModel(value = "sys_auth_group对象", description = "权限组表")
public class SysAuthGroup extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 租户id
     */
    private String tenantId;
    /**
     * 父id
     */
    // @ApiModelProperty(value = "父id")
    private String parentId;
    /**
     * 名称
     */
    // @ApiModelProperty(value = "名称")
    private String groupName;
    /**
     * 描述
     */
    // @ApiModelProperty(value = "描述")
    private String groupDesc;
    /**
     * 系统内置权限组标识 1:系统 0用户
     */
    // @ApiModelProperty(value = "系统内置权限组标识")
    private Boolean systemFlag;
    /**
     * 类型：0未知   1总权限 2基础权限 3：初始化权限 4、自定义权限
     */
    // @ApiModelProperty(value = "类型：0未知   1总权限 2基础权限 3：初始化权限 4、自定义权限")
    private Integer groupType;
}
