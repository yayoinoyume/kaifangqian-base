package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TemplateStatusRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: TemplateStatusRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模版启用、停用-请求对象")
public class TemplateStatusRequest implements Serializable {


    // @ApiModelProperty("模板id")
    private String templateId ;

//    // @ApiModelProperty("3是停用、4是启用")
//    private Integer templateStatus ;
}