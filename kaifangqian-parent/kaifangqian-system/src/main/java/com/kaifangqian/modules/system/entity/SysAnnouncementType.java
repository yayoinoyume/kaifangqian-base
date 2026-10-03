package com.kaifangqian.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author : zhenghuihan
 * create at:  2022/9/14  16:05
 * @description: 公告类型
 */
@Data
@TableName("sys_announcement_type")
// @ApiModel(value = "SysAnnouncementType", description = "公告类型")
public class SysAnnouncementType {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    // @ApiModelProperty(value = "父id")
    private String parentId;

    // @ApiModelProperty(value = "类型名称")
    private String typeName;

    // @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 创建人
     */
    // @ApiModelProperty(value = "创建人")
    private String createBy;
    /**
     * 创建时间
     */
    // @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime;
    /**
     * 更新人
     */
    // @ApiModelProperty(value = "更新人")
    private String updateBy;
    /**
     * 更新时间
     */
    // @ApiModelProperty(value = "更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date updateTime;
}