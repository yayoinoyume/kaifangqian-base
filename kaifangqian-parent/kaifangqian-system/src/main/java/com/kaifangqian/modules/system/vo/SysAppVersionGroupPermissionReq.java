package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/6/23  16:00
 * @description:
 */
@Data
public class SysAppVersionGroupPermissionReq {
    String groupId;
    List<PermissionRuleVO> ruleVOS;
}