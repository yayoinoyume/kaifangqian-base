package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/6/23  16:04
 * @description:权限相关
 */
@Data
public class PermissionRuleVO {
    private String permissionId;

    private List<String> ruleIds;
}