/**
 * @description 控件关联属性-数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 控件关联属性-数据对象
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: ControlPropertyVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("控件关联属性-数据对象")
public class ControlPropertyVo implements Serializable {

    private static final long serialVersionUID = -1043301810419120671L;

    // @ApiModelProperty("主键")
    private String id ;

    // @ApiModelProperty("关联控件id")
    private String controlId ;

    // @ApiModelProperty("控件属性类型")
    private String propertyType ;

    // @ApiModelProperty("控件属性值")
    private String propertyValue ;




}