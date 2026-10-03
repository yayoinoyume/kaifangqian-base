package com.kaifangqian.modules.opensign.vo.response.ru;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: RunSignConfirmResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response.ru
 * @ClassName: RunSignConfirmResponse
 * @author: FengLai_Gong
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
// @ApiModel("业务线实例-运行中-是否需要签署意愿校验-返回数据")
public class RunSignConfirmResponse implements Serializable {

    // @ApiModelProperty("校验类型")
    private String confirmType ;

    // @ApiModelProperty("个人实名状态,-1为未开通个人空间，0未认证，1审核中，2已认证，3未通过")
    private Integer personalAccountStatus ;


}