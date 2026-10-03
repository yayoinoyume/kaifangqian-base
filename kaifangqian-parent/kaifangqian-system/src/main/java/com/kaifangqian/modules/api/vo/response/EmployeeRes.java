/**
 * @description 企业注册响应
 */
package com.kaifangqian.modules.api.vo.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : zhenghuihan
 * create at:  2024/3/22  14:20
 * @description: 企业注册
 */
@Data
public class EmployeeRes implements Serializable {
    private static final long serialVersionUID = 1L;

    private String account;

    private String name;

    private String mobile;
}