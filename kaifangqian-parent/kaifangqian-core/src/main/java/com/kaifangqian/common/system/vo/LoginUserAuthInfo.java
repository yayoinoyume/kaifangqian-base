/**
 * @description 登录用户权限信息
 */
package com.kaifangqian.common.system.vo;

import lombok.Data;

import java.io.Serializable;
/**
 * @author : zhenghuihan
 * create at:  2022/12/20  18:07
 */
@Data
public class LoginUserAuthInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前登录租户Id
     */
    private String tenantId;

    /**
     * 当前登录部门code
     */
    private String orgCode;

    /**
     * 当前登录部门id
     */
    private String departId;

    /**
     * 授权token
     */
    private String authorizedToken;

}