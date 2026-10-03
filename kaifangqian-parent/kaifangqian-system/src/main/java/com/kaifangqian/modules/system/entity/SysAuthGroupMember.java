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
 * @description 权限组-成员表
 * @createTime 2022/9/2 18:07
 */
@Data
@TableName("sys_auth_group_member")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
// @ApiModel(value = "sys_auth_group_member对象", description = "权限组-成员表")
public class SysAuthGroupMember implements Serializable {
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
     * 权限组id
     */
    // @ApiModelProperty(value = "权限组id")
    private String groupId;
    /**
     * 权限类型
     */
    // @ApiModelProperty(value = "权限类型")
    private String authType;
    /**
     * 权限id
     */
    // @ApiModelProperty(value = "权限id")
    private String authId;
    /**
     * 部门id
     */
    // @ApiModelProperty(value = "部门id")
    private String departId;
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
