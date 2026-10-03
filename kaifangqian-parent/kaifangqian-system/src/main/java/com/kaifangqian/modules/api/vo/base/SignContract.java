/**
 * @description API接口合同id
 */
package com.kaifangqian.modules.api.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractResponse
 * @Package: com.kaifangqian.modules.api.vo.response
 * @ClassName: ContractResponse
 * @author: FengLai_Gong
 * @Date: 2024/3/19
 */
@Data
// @ApiModel("合同")
public class SignContract implements Serializable {

    private static final long serialVersionUID = -2824004633511203010L;

    // @ApiModelProperty("合同id")
    private String contractId ;
}