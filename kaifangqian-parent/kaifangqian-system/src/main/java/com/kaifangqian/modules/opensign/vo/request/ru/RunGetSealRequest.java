package com.kaifangqian.modules.opensign.vo.request.ru;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: RunGetSealRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: RunGetSealRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线实例-运行中-验证获取签章")
public class RunGetSealRequest implements Serializable {

    private static final long serialVersionUID = 8177402183475893028L;

    // @ApiModelProperty("签章id")
    private String sealId ;

    // @ApiModelProperty("操作人Id")
    private String operatorId ;

}