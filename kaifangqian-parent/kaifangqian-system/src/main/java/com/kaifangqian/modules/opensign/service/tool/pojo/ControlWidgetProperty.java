/**
 * @description 签署及填写控件属性
 */
package com.kaifangqian.modules.opensign.service.tool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: ControlWidgetProperty
 * @Package: com.kaifangqian.modules.opensign.service.tool.pojo
 * @ClassName: ControlWidgetProperty
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControlWidgetProperty implements Serializable {

    private static final long serialVersionUID = -7084429674857185669L;

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