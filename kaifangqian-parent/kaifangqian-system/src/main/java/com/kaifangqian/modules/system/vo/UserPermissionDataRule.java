package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/7/15  18:39
 * @description:
 */
@Data
public class UserPermissionDataRule {
    private String groupId;
    private String permissionDataId;
    private String conditionGroup;
    private String ruleColumn;
    private String ruleConditions;
    private String ruleValue;
}