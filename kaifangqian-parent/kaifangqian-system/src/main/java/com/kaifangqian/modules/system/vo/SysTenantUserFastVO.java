package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2023/4/3  17:14
 * @description:租户快捷操作信息
 */
@Data
public class SysTenantUserFastVO {
    /**
     * 应用ID
     */
    // @ApiModelProperty(value = "应用ID")
    private String appId;

    private String appName;

    /**
     * 菜单id
     */
    // @ApiModelProperty(value = "菜单id")
    private String permissionId;

    private String permissionName;
    /**
     * 联合ID
     */
    // @ApiModelProperty(value = "联合ID")
    private String joinId;

    private String appCode;

    private String appAddress;

    private String path;

    private String fastIcon;
}