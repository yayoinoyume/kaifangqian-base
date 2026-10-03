package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2024/7/16  11:08
 * @description:
 */
@Data
public class TenantUser3rd {
    private String id;
    private String tenantName;
    private Integer tenantType;
    private String tenantUserId;
    private String userId;
}