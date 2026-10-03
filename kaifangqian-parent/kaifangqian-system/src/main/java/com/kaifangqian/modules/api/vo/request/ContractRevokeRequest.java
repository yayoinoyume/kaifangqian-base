/**
 * @description API接口合同签署撤回
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractRevokeRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractRevokeRequest
 * @author: FengLai_Gong
 * @Date: 2024/3/4 14:05
 */
@Data
public class ContractRevokeRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = -4075908108643225129L;

    // @ApiModelProperty("合同id")
    private String contractId ;
}