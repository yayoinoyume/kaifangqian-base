package com.kaifangqian.modules.opensign.vo.request.ru;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: CompletedSignRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: CompletedSignRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线实例-运行中-完成签署-请求对象")
public class CompletedSignRequest implements Serializable {

    private static final long serialVersionUID = 5763978940665939702L;

    // @ApiModelProperty("签署意愿校验订单号")
    private String signConfirmOrderNo ;


}