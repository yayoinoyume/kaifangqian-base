/**
 * @description 业务线配置-单号生成规则细节-数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ReRuleDetailVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: ReRuleDetailVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线配置-单号生成规则细节-数据对象")
public class ReRuleDetailVo implements Serializable {

    private static final long serialVersionUID = 3436372489464933432L;

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