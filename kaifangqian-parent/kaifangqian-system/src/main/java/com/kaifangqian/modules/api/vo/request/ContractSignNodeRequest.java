/**
 * @description API接口合同信息对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
import com.kaifangqian.modules.api.vo.base.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: ContractDraftRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractDraftRequest
 * @author: FengLai_Gong
 * @Date: 2024/3/19
 */
@Data
//public class ContractDraftRequest implements Serializable {
public class ContractSignNodeRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = -7293700917961018375L;

    //基本信息
    // @ApiModelProperty("合同ID")
    private String signRuId ;

    //签署方
    // @ApiModelProperty("签署方信息")
    private List<ContractSigner> signerList ;


}