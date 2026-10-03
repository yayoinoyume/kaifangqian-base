/**
 * @description 业务线实例-签署意愿数据表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuSignConfirm
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuSignConfirm
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_sign_confirm")
// @ApiModel("业务线实例-签署意愿数据表")
public class SignRuSignConfirm implements Serializable {

    private static final long serialVersionUID = 1659432322484514103L;

    @TableId(type = IdType.ASSIGN_ID)
    // @ApiModelProperty("主键")
    private String id;

    // @ApiModelProperty("'业务线主表id'")
    private String signRuId ;

    // @ApiModelProperty("'签署方类型，1发起方，2接收方'")
    private Integer signerType ;

    // @ApiModelProperty("'signer表id或者sender表id'")
    private String signerId ;

    // @ApiModelProperty("'是否为快速签署，1是，0否'")
    private Integer agreeSkipWillingness ;

    // @ApiModelProperty("校验类型")
    private String confirmType ;

    //value字段值为：required（须实名认证）、allowed（允许不实名认证）、not_required（无需实名认证）
    private String personalSignAuth ;

    // @ApiModelProperty("不限制：NOLIMIT；个人签名方式：TEMPLATE：模板生成、HAND：手写签名")
    private String sealType ;


}