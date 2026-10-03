/**
 * @description 控件数据
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: ControlDataVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: ControlDataVo
 * @author: FengLai_Gong
 */
// @ApiModel("控件数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControlDataVo implements Serializable {


    private static final long serialVersionUID = -3448600153873319534L;

    // @ApiModelProperty("控件变更状态")
    private String controlChangeFlag ;

    // @ApiModelProperty("控件列表数")
    private List<DocControlVo> controlList ;
}