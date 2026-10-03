package com.kaifangqian.modules.opensign.vo.request.ru;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: DeleteRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: DeleteRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("发起前-撤回-整个业务线实例-请求对象")
public class RevokeRequest implements Serializable {


    private static final long serialVersionUID = -8735478973878748244L;

    // @ApiModelProperty("业务线实例id")
    private String signRuId ;

    // @ApiModelProperty("签署意愿校验订单号")
    private String signConfirmOrderNo ;

    // @ApiModelProperty("任务id")
    private String taskId ;

    // @ApiModelProperty("原因")
    private String comment ;

}