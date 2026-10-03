/**
 * @description 权限类型枚举
 * 当被请求的方法有注解PermissionData时,会在往当前request中写入数据权限信息
 */
package com.kaifangqian.common.constant.enums;

/**
 * 权限类型枚举
 *
 * @author zhh
 */
public enum AuthType {
    // 角色
    ROLE("role", "角色"),
    //用户
    USER("user", "用户"),
    //部门
    DEPT("dept", "部门"),
    //多级主管
    SUPERIOR("superior", "多级主管"),
    //全部
    ALL("all", "全部");

    private String type;

    private String name;

    AuthType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public AuthType setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthType setName(String name) {
        this.name = name;
        return this;
    }
}
