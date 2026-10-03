/**
 * @description API接口合同签署任务回调地址对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractTaskUrlRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractTaskUrlRequest
 * @author: FengLai_Gong
 * @Date: 2024/3/19
 */
@Data
public class ContractTaskUrlRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = -5626208610194753317L;

    // @ApiModelProperty("办理人账号唯一标识，个人任务：个人账号唯一标识；企业任务：企业下对应的员工唯一标识")
    private String operatorAccount ;

    // @ApiModelProperty("合同id")
    private String contractId ;

    // @ApiModelProperty("任务id")
    private String taskId ;

    // @ApiModelProperty("链接类型，h5、pc")
    private String linkType ;

    // @ApiModelProperty("同步回调地址，任务完成后的页面跳转地址，如果无，则停留在任务页面")
    private String callbackPage ;

}