/**
 * @description 规则对应表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignReRule
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignReRule
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_re_rule")
// @ApiModel("规则对应表")
public class SignReRule extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5405135510036952460L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;


    // @ApiModelProperty("'业务规则类型'")
    private Integer ruleType ;

    // @ApiModelProperty("'规则生成id'")
    private String ruleGenerateId ;

    // @ApiModelProperty("'连接字段'")
    private String link ;

}