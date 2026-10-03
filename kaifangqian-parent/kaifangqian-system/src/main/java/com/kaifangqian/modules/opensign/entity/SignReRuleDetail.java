/**
 * @description 规则详细配置表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignReRuleDetail
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignReRuleDetail
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_re_rule_detail")
// @ApiModel("规则详细配置表")
public class SignReRuleDetail extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -3642795217648832622L;


    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("'规则对应表id'")
    private String ruleId ;

    // @ApiModelProperty("'规则内容'")
    private String content ;

    // @ApiModelProperty("'规则内容类型'")
    private String contentType ;

    // @ApiModelProperty("'规则内容长度'")
    private Integer contentLength ;

    // @ApiModelProperty("'顺序'")
    private Integer contentOrder ;



}