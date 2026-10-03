package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TemplateImageConvertRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: TemplateImageConvertRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模板文件转图片请求对象")
public class TemplateImageConvertRequest implements Serializable {

    private static final long serialVersionUID = -5779400549111793967L;


    // @ApiModelProperty("模板id")
    private String templateId ;
    // @ApiModelProperty("文件id")
    private String annexId ;


}