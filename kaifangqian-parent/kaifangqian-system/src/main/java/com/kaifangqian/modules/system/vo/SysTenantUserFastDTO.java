package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2023/4/3  17:14
 * @description:租户快捷操作信息
 */
@Data
public class SysTenantUserFastDTO {
    private List<SysTenantUserFastVO> sysTenantAppVersionVOs;
}