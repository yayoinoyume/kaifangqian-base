/**
 * @description 菜单权限规则表
 */
package com.kaifangqian.common.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/3/16
 */
@Data
public class SysPermissionDataRuleModel {

    /**
     * id
     */
    private String id;

    /**
     * 对应的菜单id
     */
    private String permissionId;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 字段
     */
    private String ruleColumn;

    /**
     * 条件
     */
    private String ruleConditions;

    /**
     * 规则值
     */
    private String ruleValue;
}
