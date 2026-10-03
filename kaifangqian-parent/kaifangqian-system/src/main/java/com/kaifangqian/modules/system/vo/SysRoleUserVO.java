package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/6/27  19:07
 * @description:系统角色用户VO
 */
@Data
public class SysRoleUserVO {
    private String id;

    private String userId;

    private String username;

    private String nickName;

    private String realname;

    private String workNo;

    private String phone;

    private String email;

    /**
     * 状态(1：正常  2：冻结 ）
     */
    private Integer status;

    /**
     * 是否主管
     */
    private Boolean manageFlag;

    private String departNames;

    private String type = "user";
}