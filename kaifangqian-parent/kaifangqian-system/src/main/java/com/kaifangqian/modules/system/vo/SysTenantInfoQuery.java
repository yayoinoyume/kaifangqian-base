package com.kaifangqian.modules.system.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author : zhenghuihan
 * create at:  2023/10/18  16:47
 * @description:租户查询条件
 */
@Data
public class SysTenantInfoQuery {
    private Integer tenantType;
    private String name;
    private Integer tenantStatus;
    private Integer authStatus;
    private Date beginTime;
    private Date endTime;
    private String sysType;
}