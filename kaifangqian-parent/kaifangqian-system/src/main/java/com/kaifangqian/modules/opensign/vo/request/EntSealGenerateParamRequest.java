package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: EntSealGenerateUploadRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: EntSealGenerateUploadRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("印章生成-参数生成-请求对象")
public class EntSealGenerateParamRequest implements Serializable {

    private static final long serialVersionUID = 5592164666850753649L;


    // @ApiModelProperty("企业印章形状类型，1圆形，2椭圆形")
    private Integer entSealShapeType ;

    // @ApiModelProperty("横排文字")
    private String middleText ;

//    // @ApiModelProperty("中心文字")
//    private String center ;

    // @ApiModelProperty("下弦文字")
    private String bottomText ;

}