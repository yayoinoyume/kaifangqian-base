/**
 * @description API接口合同内部节点对象
 */
package com.kaifangqian.modules.api.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: SignInternalNode
 * @Package: com.kaifangqian.modules.api.vo.base
 * @ClassName: SignInternalNode
 * @author: FengLai_Gong
 * @Date: 2024/03/17
 */
@Data
// @ApiModel("内部签署节点")
public class ContractInternalNode implements Serializable {

    private static final long serialVersionUID = 7177160027813408013L;

    // @ApiModelProperty("节点类型：ENTERPRISE_SEAL-组织签章、AGENT_SIGN-经办人签字、LEGAL_PERSON_SIGN-法人签字、PERSONAL_SIGN-个人签名")
    private String nodeType ;

    // @ApiModelProperty("节点签署顺序")
    private String signerOrder ;

    // @ApiModelProperty("自动盖章,AUTO_SIGN")
    private String autoSign ;

    // @ApiModelProperty("印章ID")
    private String sealId ;

    // @ApiModelProperty("签署人")
    private ContractUser signer ;

    // @ApiModelProperty("签署位置集合")
    private List<ContractPositionParam> positionParamList ;

    // @ApiModelProperty("意愿校验方式,人脸FACE")
    private String signConfirm ;

    // @ApiModelProperty("意愿校验方式,CAPTCHA,PASSWORD,DOUBLE,FACE")
    private String verifyType;

    // @ApiModelProperty("是否免意愿快捷签署")
    private Integer agreeSkipWillingness;

    //value字段值为：required（须实名认证）、allowed（允许不实名认证）、not_required（无需实名认证）
    private String personalSignAuth ;

    // @ApiModelProperty("不限制：NOLIMIT；个人签名方式：TEMPLATE：模板生成、HAND：手写签名")
    private String sealType ;

//    // @ApiModelProperty("签署人姓名")
//    private String name ;

//    // @ApiModelProperty("签署人手机号")
//    private String mobile ;
}