package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: PersonSealGenerateRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: PersonSealGenerateRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("个人签名生成请求对象")
public class PersonSealGenerateParamRequest implements Serializable {


    // @ApiModelProperty("颜色,1红色，2蓝色，3黑色")
    private Integer color ;
    // @ApiModelProperty("签章文字添加内容，1为无添加，2为添加印字，3为添加之印")
    private Integer addContext ;
    // @ApiModelProperty("签章形状，1为长方形无框，2长方形有框，3为正方形无框，4为正方形有框")
    private Integer shapeStyle ;
}