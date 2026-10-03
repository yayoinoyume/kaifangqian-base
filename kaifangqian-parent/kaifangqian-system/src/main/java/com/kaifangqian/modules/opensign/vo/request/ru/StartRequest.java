package com.kaifangqian.modules.opensign.vo.request.ru;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: DeleteRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: DeleteRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("发起前-发起业务线实例-请求对象")
public class StartRequest implements Serializable {


    private static final long serialVersionUID = -8735478973878748244L;

    // @ApiModelProperty("业务线实例id")
    private String signRuId ;

}