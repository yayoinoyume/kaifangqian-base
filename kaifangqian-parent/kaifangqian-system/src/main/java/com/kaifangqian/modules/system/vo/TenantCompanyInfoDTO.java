package com.kaifangqian.modules.system.vo;

import com.kaifangqian.modules.system.entity.SysTenantUser;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2023/1/30  14:28
 * @description: 开通租户信息
 */
@Data
public class TenantCompanyInfoDTO {
    /**
     * 主键
     */
    private String id;
    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 姓名（个人、企业、工作站名称
     */
    // @ApiModelProperty(value = "姓名（个人、企业、工作站名称")
    private String name;
    /**
     * 单位证件号码
     */
    // @ApiModelProperty(value = "单位证件号码")
    private String organizationNo;
    /**
     * 注册时间
     */
    // @ApiModelProperty(value = "注册时间")
    private String createTime;
    /**
     * 认证通过时间
     */
    // @ApiModelProperty(value = "认证通过时间")
    private String verifyTime;

    /**
     * 企业管理员
     */
    // @ApiModelProperty(value = "企业管理员")
    private List<SysTenantUser> sysTenantUsers;

    // @ApiModelProperty(value = "企业管理员-用户信息")
    private List<SysUserForAddCompanyVO> sysUserVO;

    // @ApiModelProperty(value = "企业是否存在,0,不存在；1，存在，已实名")
    private Integer isExist;
}