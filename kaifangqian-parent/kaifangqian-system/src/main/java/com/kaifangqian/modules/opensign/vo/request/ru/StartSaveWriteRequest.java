package com.kaifangqian.modules.opensign.vo.request.ru;

import com.kaifangqian.modules.opensign.vo.base.sign.SaveControlVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: StartSaveWriteRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: StartSaveWriteRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("发起前-保存文档填写参数-请求对象")
public class StartSaveWriteRequest  extends SaveControlVo implements Serializable {

    private static final long serialVersionUID = -3206739942830770975L;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;





}