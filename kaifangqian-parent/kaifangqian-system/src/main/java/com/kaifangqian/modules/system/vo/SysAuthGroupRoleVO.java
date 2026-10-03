package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/9/2  14:51
 * @description: 权限组-角色VO
 */
@Data
public class SysAuthGroupRoleVO {
    private String id;
    private String groupId;
    private String roleId;
    private String roleName;
    private List<String> roleIds;
    private List<String> groupIds;
}