/**
 * @description 企业账号的注册和实名请求对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
import com.kaifangqian.modules.api.vo.base.ContractUser;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: CompanyCreateAndAuthRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: CompanyCreateAndAuthRequest
 * @author: FengLai_Gong
 * @Date: 2024/03/27
 */
@Data
// @ApiModel("企业账号的注册和实名请求对象")
public class CompanyCreateAndAuthRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = -3808597798868457919L;

    // @ApiModelProperty("账号")
    private ContractUser account ;

    // @ApiModelProperty("企业名称或组织机构名称")
    private String companyName ;

    // @ApiModelProperty("企业证件号，多证合一后建议传递统一社会信用代码")
    private String creditCode ;

    // @ApiModelProperty("法人姓名")
    private String legalPerson ;

    // @ApiModelProperty("法人证件号(身份证号)")
    private String identity ;

    // @ApiModelProperty("是否为企业自动生成印章，0：否，1：是,不传递，默认不生成印章")
    private Integer isMakeSeal ;

}