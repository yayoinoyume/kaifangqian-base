package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TemplateSaveControlLIstRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: TemplateSaveControlLIstRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模板控件下载请求对象")
public class TemplateDownloadControlRequest implements Serializable {

    private static final long serialVersionUID = -5774204742582439923L;

    // @ApiModelProperty("模板id")
    private String templateId ;


}