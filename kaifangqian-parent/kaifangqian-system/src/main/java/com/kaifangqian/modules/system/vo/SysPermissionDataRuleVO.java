package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/6/23  16:29
 * @description:权限规则信息
 */
@Data
public class SysPermissionDataRuleVO {
    /**
     * 条件组
     */
    private Integer conditionGroup;

    /**
     * 字段
     */
    private String ruleColumn;


    /**
     * 字段Id
     */
    private String ruleColumnId;

    /**
     * 条件
     */
    private String ruleConditions;

    /**
     * 规则值
     */
    private String ruleValue;
}