package com.kaifangqian.modules.opensign.vo.response;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: SignerIdentifyResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response
 * @ClassName: SignerIdentifyResponse
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("签署人身份-返回对象")
public class SignerIdentifyResponse implements Serializable {

    private static final long serialVersionUID = -1741810379254417696L;

    // @ApiModelProperty("signerId或者senderId")
    private String signerId ;

    // @ApiModelProperty("1用个人签章，2用企业签章")
    private Integer type ;

    // @ApiModelProperty("企业签章id")
    private String sealId ;

}