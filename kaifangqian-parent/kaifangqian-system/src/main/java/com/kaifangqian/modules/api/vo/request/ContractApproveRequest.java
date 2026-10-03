/**
 * @description API合同审批请求对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
import com.kaifangqian.modules.api.vo.base.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractApproveRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractDraftRequest
 * @author: resrun_Y
 * @Date: 2025/10/30
 */
@Data
public class ContractApproveRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = -7293700917961018375L;

    //基本信息
    // @ApiModelProperty("合同id")
    private String contractId;

    // 审批人
    // @ApiModelProperty("审批人")
    private ContractUser signer;

    // 审批原因
    // @ApiModelProperty("审批原因")
    private String comment;

    // 合同审批状态0,未通过；1，通过
    // @ApiModelProperty("合同审批状态0,不通过；1，通过")
    private Integer approval;

}