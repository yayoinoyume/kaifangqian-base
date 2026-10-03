/**
 * @description API接口合同签署截止时间
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractExpireDateRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractExpireDateRequest
 * @author: FengLai_Gong
 * @Date: 2024/3/23
 */
@Data
public class ContractExpireDateRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = 5956914265620652243L;

    // @ApiModelProperty("合同id")
    private String contractId ;

    // @ApiModelProperty("签署截止时间，日期格式，精确到年月日，且时间不小于当前日期")
    private String expireDate ;



}