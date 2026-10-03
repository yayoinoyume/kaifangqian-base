/**
 * @description 模板权限控制表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignTemplateAuth
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignTemplateAuth
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_template_auth")
// @ApiModel("模板权限控制表")
public class SignTemplateAuth extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -7803841273388008408L;

    // @ApiModelProperty("id")
    private String id ;

    // @ApiModelProperty("模版主表id")
    private String templateId;

    // @ApiModelProperty("权限类型，1管理员，2使用范围")
    private Integer authType ;

    // @ApiModelProperty("用户类型")
    private Integer userType ;

    // @ApiModelProperty("租户用户id")
    private String tenantUserId ;

    // @ApiModelProperty("租户id")
    private String tenantId ;


}