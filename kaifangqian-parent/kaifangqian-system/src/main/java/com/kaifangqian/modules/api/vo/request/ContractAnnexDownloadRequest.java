/**
 * @description API接口合同签署附件下载请求对象
 */
package com.kaifangqian.modules.api.vo.request;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractAnnexDownloadRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractAnnexDownloadRequest
 * @author: FengLai_Gong
 */
@Data
public class ContractAnnexDownloadRequest implements Serializable {

    private static final long serialVersionUID = 5055269221464298168L;

    // @ApiModelProperty("操作人账号唯一标识")
    private String operatorAccount ;

    // @ApiModelProperty("合同id")
    private String contractId ;
}