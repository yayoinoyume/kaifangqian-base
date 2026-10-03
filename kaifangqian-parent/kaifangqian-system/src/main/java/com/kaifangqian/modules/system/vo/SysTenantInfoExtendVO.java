package com.kaifangqian.modules.system.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2022/12/26  16:45
 * @description: 开通租户VO
 */
@Data
public class SysTenantInfoExtendVO {

    private String id;
    private String tenantId;
    private String departId;
    /**
     * 租户类型（个人、企业）
     */
    private Integer tenantType;
    /**
     * 姓名或企业名称
     */
    private String name;
    /**
     * 认证状态：未认证、认证审核中、认证审核失败、认证成功
     */
    private Integer authStatus;

    private Integer tenantStatus;

    private Integer myJobCount;
}