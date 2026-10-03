package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author : zhenghuihan
 * create at:  2023/1/30  14:28
 * @description: 开通租户信息
 */
@Data
public class CompanyAdminDTO {
    /**
     * 主键
     */
    private String id;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 租户类型:个人1 企业2 工作站3 版权局4 区县版权局5
     */
    // @ApiModelProperty(value = "租户类型")
    private Integer tenantType;
    /**
     * 姓名（个人、企业、工作站名称
     */
    // @ApiModelProperty(value = "姓名（个人、企业、工作站名称")
    private String name;

}