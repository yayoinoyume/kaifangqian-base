package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/6/23  15:35
 * @description:权限组信息
 */
@Data
public class SysAuthGroupMemberVO {
    private String id;
    /**
     * 权限组id
     */
    private String groupId;
    /**
     * 权限类型
     */
    private String authType;
    /**
     * 权限id
     */
    private String authId;
    /**
     * 部门Id
     */
    private String orgCode;

    private String name;

    private String userDepartName;

    private String pName;

    private String groupName;

    private String groupDesc;
}