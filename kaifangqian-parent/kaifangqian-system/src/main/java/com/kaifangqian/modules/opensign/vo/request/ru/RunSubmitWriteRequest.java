package com.kaifangqian.modules.opensign.vo.request.ru;

import com.kaifangqian.modules.opensign.vo.base.sign.SaveControlVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: RunSubmitWriteRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: RunSubmitWriteRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("运行中-提交填写-请求对象")
public class RunSubmitWriteRequest extends SaveControlVo implements Serializable {

    private static final long serialVersionUID = 3816167659152941863L;

    // @ApiModelProperty("业务线实例id")
    private String signRuId ;

    // @ApiModelProperty("签署意愿校验订单号")
    private String signConfirmOrderNo ;
}