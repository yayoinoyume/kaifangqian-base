package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/6/23  19:16
 * @description:权限角色信息
 */
@Data
public class SysDepartRoleVO {
    private String id;
    private String roleName;
    private Integer userCount;
}