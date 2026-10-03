package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/12/26  14:53
 * @description:
 */
@Data
public class SysAppVersionPermissionVO {
    /**
     * 应用版本ID
     */
    // @ApiModelProperty(value = "应用版本ID")
    private String appVersionId;

    List<String> permissions;
}