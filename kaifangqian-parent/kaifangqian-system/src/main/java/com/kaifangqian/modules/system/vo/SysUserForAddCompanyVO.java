package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户VO
 * </p>
 *
 * @Author zhh
 */
@Data
public class SysUserForAddCompanyVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realname;
}
