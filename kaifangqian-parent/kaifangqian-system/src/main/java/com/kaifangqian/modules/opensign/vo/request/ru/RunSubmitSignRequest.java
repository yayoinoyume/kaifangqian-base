package com.kaifangqian.modules.opensign.vo.request.ru;

import com.kaifangqian.modules.opensign.vo.base.sign.SaveControlVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: RunSubmitSignRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: RunSubmitSignRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("运行中-提交签署-请求对象")
public class RunSubmitSignRequest  extends SaveControlVo implements Serializable {

    private static final long serialVersionUID = 2392281508390260758L;


    // @ApiModelProperty("业务线实例id")
    private String signRuId ;

    // @ApiModelProperty("个人签章base64")
    private String privateSeal ;

    // @ApiModelProperty("企业签章id")
    private String entSealId;

    // @ApiModelProperty("签署意愿校验订单号")
    private String signConfirmOrderNo ;

    // @ApiModelProperty("同步回调地址")
    private String callbackPage;


}