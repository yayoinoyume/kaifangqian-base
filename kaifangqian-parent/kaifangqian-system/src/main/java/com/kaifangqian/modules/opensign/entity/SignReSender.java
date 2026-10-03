/**
 * @description 发起方内部设置
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuDocImage
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuDocControl
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_re_sender")
// @ApiModel("发起方内部设置")
public class SignReSender extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -3280655018066949695L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("'签署方主表id'")
    private String signerId ;

    // @ApiModelProperty("'顺序'")
    private Integer senderOrder ;

    // @ApiModelProperty("'发起方类型'")
    private Integer senderType ;

    // @ApiModelProperty("'发起方名称'")
    private String senderName ;

    // @ApiModelProperty("'发起方指定签章id'")
    private String senderSealId ;

    // @ApiModelProperty("'发起方盖章方式，1自动盖章，2指定位置盖章'")
    private Integer senderSignType ;

    // @ApiModelProperty("'发起方id，租户下用户id'")
    private String senderUserId ;

    // @ApiModelProperty("'外部签署人类型，1手机号，2邮箱号'")
    private Integer senderExternalType;

    // @ApiModelProperty("'外部签署人接受值'")
    private String senderExternalValue;



}