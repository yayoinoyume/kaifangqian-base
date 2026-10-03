package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TemplateListRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: TemplateListRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模版引用记录列表-请求对象")
public class TemplateLogReferenceListRequest implements Serializable {

    private static final long serialVersionUID = -7592225921034897487L;

    // @ApiModelProperty("模板id")
    private String templateId ;

    // @ApiModelProperty("页码")
    Integer pageNo = 1;

    // @ApiModelProperty("页码大小")
    Integer pageSize = 10 ;

}