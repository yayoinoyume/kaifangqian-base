/**
 * @description API接口合同信息对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractDraftRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractDraftRequest
 * @author: FengLai_Gong
 * @Date: 2024/3/19
 */
@Data
//public class ContractDraftRequest implements Serializable {
public class ContractRecallRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = -7293700917961018375L;

    //基本信息
    // @ApiModelProperty("合同ID")
    private String contractId ;


}