/**
 * @description 业务线配置-控件属性表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignReDocControlProperty
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignReDocControlProperty
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_re_doc_control_property")
// @ApiModel("业务线配置-控件属性表")
public class SignReDocControlProperty implements Serializable {

    private static final long serialVersionUID = 2110870739258347272L;

    // @ApiModelProperty("主键")
    private String id ;

    // @ApiModelProperty("业务线配置id")
    private String reId ;

    // @ApiModelProperty("关联控件id")
    private String controlId ;

    // @ApiModelProperty("控件属性类型")
    private String propertyType ;

    // @ApiModelProperty("控件属性值")
    private String propertyValue ;


}