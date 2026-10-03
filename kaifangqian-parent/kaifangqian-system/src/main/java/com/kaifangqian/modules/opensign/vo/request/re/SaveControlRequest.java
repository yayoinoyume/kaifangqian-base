package com.kaifangqian.modules.opensign.vo.request.re;

import com.kaifangqian.modules.opensign.vo.base.sign.SaveControlVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SaveControlRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: SaveControlRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线位置及参数保存-请求对象")
public class SaveControlRequest extends SaveControlVo implements Serializable {

    private static final long serialVersionUID = -3982047460168463097L;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("控件变更状态")
    private String controlChangeFlag ;

}