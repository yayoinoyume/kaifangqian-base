package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2023/4/3  15:00
 * @description:
 */
@Data
public class AppPermissionVO {
    private String appId;
    List<PermissionRuleVO> ruleVOS;
}