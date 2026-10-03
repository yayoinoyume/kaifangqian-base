package com.kaifangqian.modules.opensign.vo.response;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TemplateImageConvertResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response
 * @ClassName: TemplateImageConvertResponse
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模板文件转图片返回对象")
public class TemplateImageConvertResponse implements Serializable {


    // @ApiModelProperty("图片文件id")
    private String imageAnnexId ;
    // @ApiModelProperty("页码")
    private Integer page ;



}