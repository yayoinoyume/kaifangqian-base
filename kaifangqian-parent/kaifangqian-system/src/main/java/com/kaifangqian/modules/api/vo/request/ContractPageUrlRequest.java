/**
 * @description API接口合同签署通知链接对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractPageUrlRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractPageUrlRequest
 * @author: FengLai_Gong
 * @Date: 2024/3/18
 */
@Data
public class ContractPageUrlRequest extends ReqBaseVO implements Serializable {

//    // @ApiModelProperty("办理人账号唯一标识，个人任务：个人账号唯一标识；企业任务：企业下对应的员工唯一标识")
//    private ContractUser party ;

    // @ApiModelProperty("办理方名称")
    private String partyName ;

    // @ApiModelProperty("账号")
    private String contact ;

    // @ApiModelProperty("合同id")
    private String contractId ;

    // @ApiModelProperty("任务id")
    private String taskId ;

    // @ApiModelProperty("是否免登录")
    private Boolean noLogin;

    // @ApiModelProperty("链接失效时间")
    private String pageUrlExpireTime;

}