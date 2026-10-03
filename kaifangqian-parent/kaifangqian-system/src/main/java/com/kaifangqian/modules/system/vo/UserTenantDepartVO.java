package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/12/24  16:20
 * @description: 用户-租户部门关系
 */
@Data
public class UserTenantDepartVO {
    private Integer tenantType;
    private String tenantId;
    private String tenantName;
    private boolean useFlag;
    private boolean selectFlag;
    private String departId;
    private Integer authStatus;

    List<UserDepartVO> departs;
}