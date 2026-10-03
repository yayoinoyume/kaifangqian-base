package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
 * @author : zhenghuihan
 * create at:  2022/6/28  17:58
 * @description:用户角色
 */
@Data
public class SysUserRoleVO {
    /**
     * 部门id
     */
    private String roleId;
    /**
     * 对应的用户id集合
     */
    private List<String> userIds;
}
