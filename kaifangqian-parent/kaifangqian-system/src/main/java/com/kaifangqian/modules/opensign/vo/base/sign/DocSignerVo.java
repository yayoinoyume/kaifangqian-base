/**
 * @description 业务线签约方数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: DocSignerVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: DocSignerVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线签约方数据对象")
public class DocSignerVo implements Serializable {

    private static final long serialVersionUID = -5348868457480088206L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;

    // @ApiModelProperty("'签署方类型，1发起方，2接收方'")
    private Integer signerType ;

    // @ApiModelProperty("'签署方名称'")
    private String signerName ;

    // @ApiModelProperty("'签署方顺序'")
    private Integer signerOrder ;

    // @ApiModelProperty("'外部签署人类型，1手机号，2邮箱号'")
    private Integer signerExternalType ;

    // @ApiModelProperty("'外部签署人接受值'")
    private String signerExternalValue ;

    // @ApiModelProperty("发起方数据列表")
    private List<DocSenderVo> senderList ;

    // @ApiModelProperty("签署人租户下用户id")
    private String singerUserId ;

    // @ApiModelProperty("签署人租户下用户名称")
    private String singerUserName ;

    // @ApiModelProperty("是否需要签署")
    private Integer signFlag ;

    // @ApiModelProperty("填写状态，0无需填写，1为未填写，2为待填写，3已填写，4已拒填")
    private Integer writeStatus = -1;

    // @ApiModelProperty("签署状态，1为未签署，2为待签署，3已签署，4已拒签")
    private Integer signStatus = -1 ;

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
