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
@TableName("sys_app_version_permission")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
// @ApiModel(value = "sys_app_version_permission对象", description = "应用版本功能表")
public class SysAppVersionPermission extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 应用ID
     */
    // @ApiModelProperty(value = "应用ID")
    private String appInfoId;
    /**
     * 应用版本ID
     */
    // @ApiModelProperty(value = "应用版本ID")
    private String appVersionId;
    /**
     * 应用功能ID
     */
    // @ApiModelProperty(value = "应用功能ID")
    private String permissionId;
}
