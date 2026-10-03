package com.kaifangqian.modules.opensign.vo.request.ru;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: RunRejectSignRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: RunRejectSignRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("运行中-拒绝签署-请求对象")
public class RunRejectSignRequest implements Serializable {

    private static final long serialVersionUID = -3803945598616150138L;

    // @ApiModelProperty("业务线实例id")
    private String signRuId ;

    // @ApiModelProperty("签署意愿校验订单号")
    private String signConfirmOrderNo ;

    // @ApiModelProperty("原因")
    private String comment ;

}