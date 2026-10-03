/**
 * @description API接口合同模板参数
 */
package com.kaifangqian.modules.api.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TemplateParam
 * @Package: com.kaifangqian.modules.api.vo.base
 * @ClassName: TemplateParam
 * @author: FengLai_Gong
 * @Date: 2024/3/19
 */
@Data
// @ApiModel("模板参数")
public class ContractTemplateParam implements Serializable {

    private static final long serialVersionUID = 4778823872044013017L;

    // @ApiModelProperty("参数key")
    private String paramKey ;

    // @ApiModelProperty("参数value")
    private String paramValue ;

}