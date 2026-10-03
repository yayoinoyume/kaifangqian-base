package com.kaifangqian.modules.opensign.vo.request.ru;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: RunRejectWriteRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: RunRejectWriteRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("运行中-拒绝填写-请求对象")
public class RunRejectWriteRequest implements Serializable {

    private static final long serialVersionUID = 2832473486677539022L;

    // @ApiModelProperty("业务线实例id")
    private String signRuId ;

    // @ApiModelProperty("签署意愿校验订单号")
    private String signConfirmOrderNo ;

    // @ApiModelProperty("原因")
    private String comment ;

}