package com.kaifangqian.modules.system.entity;

import java.io.Serializable;
import java.util.List;

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
@TableName("sys_app_version")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
// @ApiModel(value = "sys_app_version对象", description = "应用版本表")
public class SysAppVersion extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 所属app
     */
    // @ApiModelProperty(value = "所属app")
    private String appInfoId;
    /**
     * 版本名称
     */
    // @ApiModelProperty(value = "版本名称")
    private String versionName;
    /**
     * 版本code
     */
    // @ApiModelProperty(value = "版本code")
    private String versionCode;
    /**
     * 状态,0草稿，1已发布
     */
    // @ApiModelProperty(value = "状态")
    private Integer versionStatus;

    /**
     * 类型：1团体 2个人 0不限制
     */
    // @ApiModelProperty(value = "类型：1团体 2个人 0不限制")
    private Integer versionType;
    /**
     * 版本描述
     */
    // @ApiModelProperty(value = "版本描述")
    private String versionDesc;
    /**
     * 是否默认初始化权限1是0否
     */
    // @ApiModelProperty(value = "是否默认初始化权限1是0否")
    private boolean defaultFlag;

    /**
     * 权限list
     */
    private transient List<String> permissions;
}
