/**
 * @description 业务线实例-关键字设置属性表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuKeywordProperty
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuKeywordProperty
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_keyword_property")
// @ApiModel("业务线实例-关键字设置属性表")
public class SignRuKeywordProperty implements Serializable {

    private static final long serialVersionUID = -3569491307989036232L;

    // @ApiModelProperty("主键")
    private String id ;

    // @ApiModelProperty("业务线实例id")
    private String ruId ;

    // @ApiModelProperty("关键字id")
    private String keywordId ;

    // @ApiModelProperty("控件属性类型，包括关联文件，查询方式（全部，部分，正序，倒序，查询范围）")
    private String propertyType ;

    // @ApiModelProperty("控件属性值")
    private String propertyValue ;


}