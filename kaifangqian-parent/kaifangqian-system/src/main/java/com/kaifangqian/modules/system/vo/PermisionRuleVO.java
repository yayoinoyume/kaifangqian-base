package com.kaifangqian.modules.system.vo;

import com.kaifangqian.modules.system.entity.SysPermissionData;
import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2023/1/7  14:32
 * @description: 按钮权限vo
 */
@Data
public class PermisionRuleVO {
    private String id;
    private String name;

    //数据权限列表
    private List<SysPermissionData> rules;
}