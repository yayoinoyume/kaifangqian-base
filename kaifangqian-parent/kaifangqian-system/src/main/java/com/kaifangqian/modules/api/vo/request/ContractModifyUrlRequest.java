/**
 * @description API接口合同签署地址修改对象
 */
package com.kaifangqian.modules.api.vo.request;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractModifyUrlRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractModifyUrlRequest
 * @author: FengLai_Gong
 */
@Data
public class ContractModifyUrlRequest implements Serializable {

    private static final long serialVersionUID = 3347922986156212945L;

    // @ApiModelProperty("操作人账号唯一标识")
    private String operatorAccount ;

    // @ApiModelProperty("合同id")
    private String contractId ;
}