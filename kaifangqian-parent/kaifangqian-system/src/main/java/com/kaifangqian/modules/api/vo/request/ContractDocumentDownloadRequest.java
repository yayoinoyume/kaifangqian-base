/**
 * @description API接口合同签署回调对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractDocumentDownloadRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractDocumentDownloadRequest
 * @author: FengLai_Gong
 * @Date: 2024/3/19
 */
@Data
public class ContractDocumentDownloadRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = -534808915453304145L;


//    // @ApiModelProperty("合同参与人或业务线中指定的签约文件下载人")
//    private ContractUser operator;

    // @ApiModelProperty("合同参与人或业务线中指定的签约文件下载人的手机号")
    private String contact ;

    // @ApiModelProperty("合同id")
    private String contractId ;

}