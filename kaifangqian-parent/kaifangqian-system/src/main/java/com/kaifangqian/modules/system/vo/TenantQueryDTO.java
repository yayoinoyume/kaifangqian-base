package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2023/1/30  18:32
 * @description: 查询
 */
@Data
public class TenantQueryDTO {
    /**
     * 租户类型
     */
    // @ApiModelProperty(value = "租户类型")
    private Integer tenantType;
    /**
     * 姓名（个人、企业、工作站名称
     */
    // @ApiModelProperty(value = "姓名（个人、企业、工作站名称")
    private java.lang.String tenantName;
    /**
     * 认证状态 未认证0 审核中1 已认证2 未通过-1
     */
    // @ApiModelProperty(value = "认证状态")
    private java.lang.Integer authStatus;

    private String beginTime;
    private String endTime;
}