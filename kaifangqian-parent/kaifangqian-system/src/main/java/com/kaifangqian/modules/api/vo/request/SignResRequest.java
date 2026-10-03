/**
 * @description 获取业务线列表
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignResRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: SignResRequest
 * @author: FengLai_Gong
 * @Date: 2024/3/4 14:05
 */
@Data
// @ApiModel("获取业务线列表")
public class SignResRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = 2718430929268123520L;

//    // @ApiModelProperty("法人单位名称，完整的法人单位名称，与工商注册信息一致")
//    private String companyName ;

    // @ApiModelProperty("办理人账号，办理人需要在该法人单位下，支持邮箱和手机")
    private String contact ;
}