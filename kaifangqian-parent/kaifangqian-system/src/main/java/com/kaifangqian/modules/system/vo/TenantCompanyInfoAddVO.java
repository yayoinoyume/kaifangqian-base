package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2023/1/30  14:28
 * @description: 开通租户信息
 */
@Data
public class TenantCompanyInfoAddVO {

    /**
     * 姓名（个人、企业、工作站名称
     */
    // @ApiModelProperty(value = "姓名（个人、企业、工作站名称")
    private String name;

    // @ApiModelProperty(value = "提交IP地址")
    private String submitIp;

}