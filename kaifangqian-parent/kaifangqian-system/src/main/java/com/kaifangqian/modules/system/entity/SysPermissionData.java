package com.kaifangqian.modules.system.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author zhenghuihan
 * @description 权限策略表
 * @createTime 2022/9/2 18:08
 */
@Data
@TableName("sys_permission_data")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
// @ApiModel(value = "sys_permission_data对象", description = "权限策略表")
public class SysPermissionData implements Serializable {
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
    // @ApiModelProperty(value = "租户id")
    private String tenantId;
    /**
     * 权限菜单id
     */
    // @ApiModelProperty(value = "权限菜单id")
    private String permissionId;
    /**
     * 权限类型
     */
    // @ApiModelProperty(value = "权限类型")
    private String dataType;
    /**
     * 名称
     */
    // @ApiModelProperty(value = "名称")
    private String dataName;
    /**
     * 描述
     */
    // @ApiModelProperty(value = "描述")
    private String dataDesc;
    /**
     * 默认标识1默认 2非默认
     */
    // @ApiModelProperty(value = "默认标识1默认 2非默认")
    private Integer defaultFlag;
    /**
     * 排序
     */
    // @ApiModelProperty(value = "排序")
    private Integer orderNo;
    /**
     * 创建人
     */
    // @ApiModelProperty(value = "创建人")
    private String createBy;
    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @ApiModelProperty(value = "创建日期")
    private Date createTime;
}
