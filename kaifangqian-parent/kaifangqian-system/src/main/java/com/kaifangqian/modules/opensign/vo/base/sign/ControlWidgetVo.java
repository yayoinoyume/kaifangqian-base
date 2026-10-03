/**
 * @description 填写控件属性
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ControlWidgetVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: ControlWidgetVo
 * @author: FengLai_Gong
 */
// @ApiModel("填写控件属性")
@Data
public class ControlWidgetVo implements Serializable {

    private static final long serialVersionUID = -1432720126169390026L;

    private Integer x ;

    private Integer y ;

    private Integer w ;

    private Integer h ;

    private Integer p ;

    private String n ;

    private Boolean v ;

    private Boolean click ;

    private String uid ;


}