/**
 * @description 业务线抄送人表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuApprove
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuApprove
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_re_ccer")
// @ApiModel("业务线抄送人表")
public class SignReCcer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 173145695467807970L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("'业务线主表id'")
    private String signReId ;


    // @ApiModelProperty("'抄送人类型，1内部，2外部'")
    private Integer ccerType ;

    // @ApiModelProperty("'内部抄送人id'")
    private String internalCcerId ;

    // @ApiModelProperty("'外部抄送人名称'")
    private String externalCcerName ;

    // @ApiModelProperty("'外部抄送人抄送类型，1手机号，2邮箱号'")
    private Integer externalCcedType ;

    // @ApiModelProperty("'外部抄送人抄送值'")
    private String externalCcedValue ;


}