package com.kaifangqian.modules.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author zhenghuihan
 * @description 权限组-权限表
 * @createTime 2022/9/2 18:08
 */
@Data
@TableName("sys_auth_group_permission")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
// @ApiModel(value = "sys_auth_group_permission对象", description = "权限组-权限表")
public class SysAuthGroupPermission implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 权限组ID
     */
    // @ApiModelProperty(value = "权限组ID")
    private String groupId;
    /**
     * 应用id
     */
    private String appId;
    /**
     * 菜单id
     */
    // @ApiModelProperty(value = "菜单id")
    private String permissionId;
    /**
     * 菜单权限
     */
    // @ApiModelProperty(value = "菜单权限")
    private String permissionPerms;
    /**
     * 权限策略id
     */
    // @ApiModelProperty(value = "权限策略id")
    private String permissionDataId;
}
