/**
 * @description 用户签章授权表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("user_seal_auth")
// @ApiModel("用户签章授权表")
public class UserSealAuth extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2546725642070245357L;

    // @ApiModelProperty("'主键'")
    private String id;

    // @ApiModelProperty("租户-用户主表id")
    private String tenantUserId;

    // @ApiModelProperty("租户主表id")
    private String tenantId;

    // @ApiModelProperty("业务线主表id")
    private String signReId;

    // @ApiModelProperty("授权日期")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date authTime;

    // @ApiModelProperty("签名ID")
    private String sealId;

    // @ApiModelProperty("授权状态1：已授权，0：未授权")
    private Integer authStatus;

    @NotBlank(message = "校验类型不能为空")
    // @ApiModelProperty("校验类型不能为空")
    private String confirmType;

    // @ApiModelProperty("类型:phone.email")
    private String type;

    // @ApiModelProperty(value = "验证码")
    private transient String captcha;

    // @ApiModelProperty(value = "验证码key")
    private transient String captchaKey;

    // @ApiModelProperty(value = "签约密码")
    private transient String password;

    // @ApiModelProperty("对应值")
    private String typeValue;

    // @ApiModelProperty("用户提交值")
    private String userPara;
}