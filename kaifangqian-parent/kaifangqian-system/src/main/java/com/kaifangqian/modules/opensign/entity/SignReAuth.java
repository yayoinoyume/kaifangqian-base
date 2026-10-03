/**
 * @description 业务线权限控制表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignReAuth
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignReAuth
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_re_auth")
// @ApiModel("业务线权限控制表")
public class SignReAuth extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -2546725642070245357L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;


    // @ApiModelProperty("'权限类型，1管理员，2使用范围，3查看权限，4下载权限'")
    private Integer authType ;

    // @ApiModelProperty("'用户类型'")
    private Integer userType ;

    // @ApiModelProperty("'用户id'")
    private String userId ;

    // @ApiModelProperty("'租户id'")
    private String tenantId ;


    // @ApiModelProperty("'下载权限类型，1参与人，2查看人，3全部'")
    private Integer downloaderType ;




}