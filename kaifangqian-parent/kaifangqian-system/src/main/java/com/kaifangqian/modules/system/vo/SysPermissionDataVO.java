package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/6/23  16:27
 * @description:权限规则数据
 */
@Data
public class SysPermissionDataVO {
    private String id;
    private String permissionId;
    private String dataType;
    private String dataName;
    private String dataDesc;
    private List<SysPermissionDataRuleVO> rules;
}