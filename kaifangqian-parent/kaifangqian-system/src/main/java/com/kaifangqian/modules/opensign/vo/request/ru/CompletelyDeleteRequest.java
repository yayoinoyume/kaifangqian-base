package com.kaifangqian.modules.opensign.vo.request.ru;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: CleanupRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: CleanupRequest
 * @author: FengLai_Gong
 */
@Data
public class CompletelyDeleteRequest implements Serializable {

    // @ApiModelProperty("业务线实例id")
    private String signRuId ;
}