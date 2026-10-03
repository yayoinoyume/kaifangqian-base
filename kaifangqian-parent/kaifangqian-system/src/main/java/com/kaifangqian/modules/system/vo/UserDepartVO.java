package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/12/24  16:24
 * @description: 租户下用户部门VO
 */
@Data
public class UserDepartVO {
    private String tenantId;
    private String departId;
    private String departName;
    private boolean selectFlag;
}