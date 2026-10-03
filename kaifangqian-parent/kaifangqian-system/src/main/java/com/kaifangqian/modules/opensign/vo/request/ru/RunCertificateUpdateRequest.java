package com.kaifangqian.modules.opensign.vo.request.ru;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: RunCertificateUpdateRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: RunCertificateUpdateRequest
 * @author: FengLai_Gong
 */
// @ApiModel("业务线实例-运行中-更新证书-请求对象")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RunCertificateUpdateRequest implements Serializable {

    private static final long serialVersionUID = -6220597935958995594L;

    // @ApiModelProperty("需要更新证书的租户id")
    private String tenantId ;
    // @ApiModelProperty("需要更新的证书类型")
    private Integer certType ;
    // @ApiModelProperty("需要更新的持证主体类型")
    private Integer holderType ;



}