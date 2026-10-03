/**
 * @description API接口合同签署查看地址对象
 */
package com.kaifangqian.modules.api.vo.request;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractViewUrlRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: ContractViewUrlRequest
 * @author: FengLai_Gong
 * @Date: 2023/3/12 10:05
 */
@Data
public class ContractViewUrlRequest implements Serializable {

    private static final long serialVersionUID = 8735968957210693911L;

    // @ApiModelProperty("查看人账号唯一标识")
    private String account ;

    // @ApiModelProperty("合同id")
    private String contractId ;

    // @ApiModelProperty("链接类型，h5、pc")
    private String linkType ;
}