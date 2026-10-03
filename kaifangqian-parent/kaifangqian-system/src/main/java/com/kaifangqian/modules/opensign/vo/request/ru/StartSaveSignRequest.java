package com.kaifangqian.modules.opensign.vo.request.ru;

import com.kaifangqian.modules.opensign.vo.base.sign.SaveControlVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: StartSaveSignRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: StartSaveSignRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("发起前-保存签署位置及参数-请求对象")
public class StartSaveSignRequest extends SaveControlVo implements Serializable {


    private static final long serialVersionUID = 4037679196156295991L;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;


}