package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
/**
 * @author : zhenghuihan
 * create at:  2022/6/27  19:07
 * @description:租户应用版本信息
 */
@Data
public class SysTenantAppVersionVO {
    /**
     * 主键
     */
    // @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 租户id
     */
    // @ApiModelProperty(value = "租户id")
    private String tenantId;
    /**
     * 应用id
     */
    // @ApiModelProperty(value = "应用id")
    private String appId;
    /**
     * 图标
     */
    // @ApiModelProperty(value = "图标")
    private String appIcon;

    /**
     * 图标地址
     */
    // @ApiModelProperty(value = "图标地址")
    private String appIconAddress;
    /**
     * 应用名称
     */
    // @ApiModelProperty(value = "应用名称")
    private String appName;
    /**
     * 应用描述
     */
    // @ApiModelProperty(value = "应用描述")
    private String appDesc;

    /**
     * 是否内置应用1是 0 否
     */
    // @ApiModelProperty(value = "是否默认应用1是 0 否")
    private boolean defaultFlag;

    /**
     * 应用版本id
     */
    // @ApiModelProperty(value = "应用版本id")
    private String appVersionId;


    /**
     * 应用版本名称
     */
    // @ApiModelProperty(value = "应用版本名称")
    private String appVersionName;
    /**
     * 状态
     */
    // @ApiModelProperty(value = "状态,1可用 0不可用")
    private Integer status;

    /**
     * 是否全部可用
     */
    // @ApiModelProperty(value = "是否全部可用")
    private Boolean useful;

    /**
     * 用户列表
     */
    // @ApiModelProperty(value = "用户列表")
    private List<NameAndIdForView> users;
}
