package com.kaifangqian.modules.opensign.vo.request.ru;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: RunVerifyCertificateRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: RunVerifyCertificateRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线实例-运行中-验证证书")
public class RunVerifyCertificateRequest implements Serializable {

    private static final long serialVersionUID = -4164815068765958415L;

    // @ApiModelProperty("操作人Id")
    private String operatorId ;


}