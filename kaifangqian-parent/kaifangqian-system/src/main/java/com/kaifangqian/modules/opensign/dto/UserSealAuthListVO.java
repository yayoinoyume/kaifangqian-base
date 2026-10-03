/**
 * @description 企业印章授权信息
 */
package com.kaifangqian.modules.opensign.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author : zhenghuihan
 * create at:  2024/6/28  14:57
 * @description:
 */
@Data
public class UserSealAuthListVO {
    private String id;
    // @ApiModelProperty("授权企业")
    private String tenantName;
    // @ApiModelProperty("签署业务")
    private String signReName;
    // @ApiModelProperty("授权日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date authTime;
    // @ApiModelProperty("签章图片ID")
    private String annexId;
    // @ApiModelProperty("授权状态1：已授权，0：未授权")
    private Integer authStatus;
}