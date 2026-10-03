package com.kaifangqian.modules.system.vo;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/12/26  16:45
 * @description: 开通租户VO
 */
@Data
public class SysTenantInfoVO {
    /**
     * 主键
     */
    // @ApiModelProperty(value = "租户主键")
    private String id;
    /**
     * 租户类型 1团体 2个人
     */
    // @ApiModelProperty(value = "租户类型")
    private Integer tenantType;
     /**
     * 租户名称
     */
    // @ApiModelProperty(value = "租户名称")
    private String tenantName;
    /**
     * 租户状态
     */
    // @ApiModelProperty(value = "租户状态1:启用 2停用")
    private Integer tenantStatus;
    /**
     * 租户描述
     */
    // @ApiModelProperty(value = "租户描述")
    private String tenantDesc;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 初始化密码
     */
    private String password;

    /**
     * 授权内置应用列表
     */
    private List<String> inVersionIds;

    /**
     * 授权业务应用列表
     */
    private List<String> outVersionIds;
}