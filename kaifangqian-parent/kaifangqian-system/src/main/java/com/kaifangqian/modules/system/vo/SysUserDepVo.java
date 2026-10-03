package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author zhenghuihan
 * @description 用户部门信息
 * @createTime 2022/9/2 18:16
 */
@Data
public class SysUserDepVo {
    private String id;
    private String userId;
    private String username;
    private String realname;
    private String orgCode;
    private String departName;
}
