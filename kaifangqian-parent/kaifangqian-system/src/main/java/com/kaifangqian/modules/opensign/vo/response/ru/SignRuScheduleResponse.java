package com.kaifangqian.modules.opensign.vo.response.ru;

import com.kaifangqian.modules.opensign.vo.base.sign.DocSignerVo;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: SignRuScheduleResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response.ru
 * @ClassName: SignRuScheduleResponse
 * @author: FengLai_Gong
 */
@Data
public class SignRuScheduleResponse implements Serializable {

    private static final long serialVersionUID = -6065479865079724443L;

    // @ApiModelProperty("签署人信息")
    private List<DocSignerVo> signerVoList ;

    // @ApiModelProperty("签署顺序类型，1有序签署、2无序签署")
    private Integer signOrderType;

}