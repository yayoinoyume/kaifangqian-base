/**
 * @description 签署人主表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuSigner
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuDocControl
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_re_signer")
// @ApiModel("签署人主表")
public class SignReSigner extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -7275051846243061218L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("'业务线主表id'")
    private String signReId ;

    // @ApiModelProperty("'签署方类型，1发起方，2个人接收方,3企业接收方'")
    private Integer signerType ;

    // @ApiModelProperty("'签署方名称'")
    private String signerName ;

    // @ApiModelProperty("'签署方顺序'")
    private Integer signerOrder ;

    // @ApiModelProperty("签署人租户下用户id")
    private String signerUserId ;



}