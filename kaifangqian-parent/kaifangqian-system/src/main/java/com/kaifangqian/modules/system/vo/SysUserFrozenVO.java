package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/6/28  17:58
 * @description:用户状态
 */
@Data
public class SysUserFrozenVO {
    private List<String> ids;
    /**
     * 状态(1：正常  2：冻结 ）
     */
    private Integer status;

    private String password;
}