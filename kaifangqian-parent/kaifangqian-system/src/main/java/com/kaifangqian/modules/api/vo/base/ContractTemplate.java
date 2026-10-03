/**
 * @description API接口合同模板
 */
package com.kaifangqian.modules.api.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: Template
 * @Package: com.kaifangqian.modules.api.vo.base
 * @ClassName: Template
 * @author: FengLai_Gong
 * @Date: 2024/3/20
 */
@Data
// @ApiModel("模板")
public class ContractTemplate implements Serializable {

    private static final long serialVersionUID = -7354127157419325073L;

    // @ApiModelProperty("模板id")
    private String templateId ;

    // @ApiModelProperty("模板名称")
    private String templateName ;

    // @ApiModelProperty("模板参数集合")
    private List<ContractTemplateParam> templateParamList ;
}