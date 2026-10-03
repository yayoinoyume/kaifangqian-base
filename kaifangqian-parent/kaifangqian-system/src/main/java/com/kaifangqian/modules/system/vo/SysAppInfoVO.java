package com.kaifangqian.modules.system.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/12/26  10:36
 * @description: 应用管理VO
 */
@Data
public class SysAppInfoVO {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 名称
     */
    // @ApiModelProperty(value = "名称")
    private String appName;
    /**
     * 图标
     */
    // @ApiModelProperty(value = "图标")
    private String appIcon;
    /**
     * 描述
     */
    // @ApiModelProperty(value = "描述")
    private String appDesc;
    /**
     * 是否已经拥有
     */
    // @ApiModelProperty(value = "是否已经拥有")
    private boolean containsFlag = false;

    private List<SysAppVersionVO> appVersionVOS;
}