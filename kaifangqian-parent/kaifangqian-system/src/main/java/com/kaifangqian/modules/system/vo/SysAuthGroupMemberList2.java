package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/7/6  19:45
 * @description:权限组成员列表
 */
@Data
public class SysAuthGroupMemberList2 {

    // @ApiModelProperty(value = "权限组id")
    private List<String> groupIds;

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
     * 部门Id
     */
    // @ApiModelProperty(value = "部门Id")
    private String departId;

    /**
     * 租户Id
     */
    // @ApiModelProperty(value = "租户Id")
    private String tenantId;
}