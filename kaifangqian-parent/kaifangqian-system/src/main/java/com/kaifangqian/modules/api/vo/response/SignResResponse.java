/**
 * @description 签署业务线
 */
package com.kaifangqian.modules.api.vo.response;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignResResponse
 * @Package: com.kaifangqian.modules.api.vo.response
 * @ClassName: SignResResponse
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("获取业务线列表")
public class SignResResponse implements Serializable {

    private static final long serialVersionUID = 6945950322990498215L;

    // @ApiModelProperty("业务线ID")
    private String signReId ;

    // @ApiModelProperty("业务线名称")
    private String signReName ;

}