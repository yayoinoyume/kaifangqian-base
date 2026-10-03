package com.kaifangqian.modules.system.model;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/8/31  14:37
 * @description: 用户
 */
@Data
public class SysUserSearchModel {

    private String id;
    /**
     * 登录账号
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realname;
}