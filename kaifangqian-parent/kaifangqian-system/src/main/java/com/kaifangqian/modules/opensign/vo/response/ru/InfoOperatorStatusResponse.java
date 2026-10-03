package com.kaifangqian.modules.opensign.vo.response.ru;

// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 业务处理状态
 * @Package: com.kaifangqian.modules.opensign.vo.response.ru
 * @ClassName: InfoOperatorStatusResponse
 * @author: FengLai_Gong
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InfoOperatorStatusResponse implements Serializable {

    private static final long serialVersionUID = 3684282734048702185L;

    // @ApiModelProperty("操作人状态，1待办理，2已办理")
    private Integer operatorStatus ;

    // @ApiModelProperty("业务线实例状态")
    private Integer ruStatus ;

    // @ApiModelProperty("校验状态")
    private Integer checkStatus ;

}