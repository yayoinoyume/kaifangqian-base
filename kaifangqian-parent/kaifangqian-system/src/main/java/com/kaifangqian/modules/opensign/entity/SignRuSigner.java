/**
 * @description 业务线实例-签署人主表
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
@TableName("sign_ru_signer")
// @ApiModel("业务线实例-签署人主表")
public class SignRuSigner extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6541488767464512447L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;


    // @ApiModelProperty("'签署方类型，1发起方，2外部个人接收方 3外部企业接收方'")
    private Integer signerType ;

    // @ApiModelProperty("'签署方名称'")
    private String signerName ;

    // @ApiModelProperty("'签署方顺序'")
    private Integer signerOrder ;

    // @ApiModelProperty("'外部签署人类型，1手机号，2邮箱号'")
    private Integer signerExternalType ;

    // @ApiModelProperty("'外部签署人接受值'")
    private String signerExternalValue ;

    // @ApiModelProperty("签署人租户下用户id")
    private String signerUserId ;

    // @ApiModelProperty("是否需要签署")
    private Boolean signFlag ;

}