package com.kaifangqian.modules.opensign.vo.response;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: RunCertificateVerifyResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response
 * @ClassName: RunCertificateVerifyResponse
 * @author: FengLai_Gong
 */
// @ApiModel("业务线实例-运行中-验证证书-返回对象")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RunCertificateVerifyResponse implements Serializable {


    private static final long serialVersionUID = -2195785722688754281L;

    // @ApiModelProperty("返回信息,不校验证书,无证书,证书无效,证书有效")
    private String returnMsg ;
    // @ApiModelProperty("返回信息,1、不校验证书,2、无证书,3、证书无效,4、证书有效")
    private Integer returnCode ;
    // @ApiModelProperty("需要更新证书的租户id")
    private String tenantId ;
    // @ApiModelProperty("部门id")
    private String departId ;
    // @ApiModelProperty("需要更新的证书类型")
    private Integer certType ;
    // @ApiModelProperty("需要更新的持证主体类型")
    private Integer holderType ;

    // @ApiModelProperty("证书颁发机构")
    private String issueOrg ;
    // @ApiModelProperty("企业租户下-签署租户实名认证状态")
    private Integer signerAuthStatus;
    // @ApiModelProperty("企业租户下-签署租户是否为管理员")
    private Integer signerIsCompanyManager;
    // @ApiModelProperty("企业租户下-签署租户ID")
    private String signerTenantId;
}