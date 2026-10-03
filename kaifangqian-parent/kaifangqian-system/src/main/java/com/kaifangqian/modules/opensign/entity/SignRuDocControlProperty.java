/**
 * @description 业务线实例-控件属性表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuDocControlProperty
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuDocControlProperty
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_doc_control_property")
// @ApiModel("业务线实例-控件属性表")
public class SignRuDocControlProperty implements Serializable {

    private static final long serialVersionUID = -1925775617726998478L;

    // @ApiModelProperty("主键")
    private String id ;

    // @ApiModelProperty("业务线实例id")
    private String ruId ;

    // @ApiModelProperty("关联控件id")
    private String controlId ;

    // @ApiModelProperty("控件属性类型")
    private String propertyType ;

    // @ApiModelProperty("控件属性值")
    private String propertyValue ;



}