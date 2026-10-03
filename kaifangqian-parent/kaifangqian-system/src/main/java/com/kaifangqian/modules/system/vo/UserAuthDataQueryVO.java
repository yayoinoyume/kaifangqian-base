package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/6/27  17:57
 * @description:
 */
@Data
public class UserAuthDataQueryVO {
    private String tenantId;
    private String userId;
    private String departId;
    private String orgCode;
    private List<String> roleIds;
    private List<String> departIds;
    private String permissionId;

    private String appId;
    private String appVersionId;
}