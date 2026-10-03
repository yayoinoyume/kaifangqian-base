/**
 * @description 意愿认证方式
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: SignComfirmVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: SignComfirmVo
 * @author: FengLai_Gong
 */
@Data
public class SignConfirmVo implements Serializable {

    private static final long serialVersionUID = 7880578443660519873L;

    // @ApiModelProperty("签署意愿校验方式")
    private String confirmWay ;

    // @ApiModelProperty("签署意愿校验类型列表")
    private List<String> confirmTypeList ;

}