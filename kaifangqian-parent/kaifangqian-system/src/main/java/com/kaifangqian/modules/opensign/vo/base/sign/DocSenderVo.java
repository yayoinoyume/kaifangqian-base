/**
 * @description 业务线发起方据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: DocSenderVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: DocSenderVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线发起方据对象")
public class DocSenderVo implements Serializable {

    private static final long serialVersionUID = 8170537268496301279L;

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

    // @ApiModelProperty("'发起方指定签章名称'")
    private String senderSealName ;

    // @ApiModelProperty("'发起方盖章方式，1自动盖章，2指定位置盖章'")
    private Integer senderSignType ;

    // @ApiModelProperty("'发起方id，租户下用户id'")
    private String senderUserId ;

    // @ApiModelProperty("租户下用户名称")
    private String senderUserName ;

    // @ApiModelProperty("填写状态，0无需填写，1为未填写，2为待填写，3已填写，4已拒填")
    private Integer writeStatus = -1;

    // @ApiModelProperty("签署状态，1为未签署，2为待签署，3已签署，4已拒签")
    private Integer signStatus = -1 ;

    // @ApiModelProperty("'外部签署人类型，1手机号，2邮箱号'")
    private Integer senderExternalType;

    // @ApiModelProperty("'外部签署人接受值'")
    private String senderExternalValue;

    // @ApiModelProperty("校验类型，0是关闭校验，1是开启校验，默认是0")
    private Integer confirmType = 0;

    // @ApiModelProperty("意愿校验类型：CAPTCHA，PASSWORD，DOUBLE，FACE;")
    private String verifyType;

    // @ApiModelProperty("是否为快速签署，1是，0否")
    private Integer agreeSkipWillingness = 0;

    //value字段值为：required（须实名认证）、allowed（允许不实名认证）、not_required（无需实名认证）
    private String personalSignAuth ;

    // @ApiModelProperty("不限制：NOLIMIT；个人签名方式：TEMPLATE：模板生成、HAND：手写签名")
    private String sealType ;




}