/**
 * @description API接口合同删除对象
 */
package com.kaifangqian.modules.api.vo.request;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractDeleteRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractDeleteRequest
 * @author: FengLai_Gong
 * @Date: 2024/03/19
 */
@Data
public class ContractDeleteRequest implements Serializable {

    private static final long serialVersionUID = -3571860201015999986L;

    // @ApiModelProperty("操作人账号唯一标识")
    private String operatorAccount ;

    // @ApiModelProperty("合同id")
    private String contractId ;



}