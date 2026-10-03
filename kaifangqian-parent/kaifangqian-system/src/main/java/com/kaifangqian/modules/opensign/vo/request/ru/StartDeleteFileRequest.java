package com.kaifangqian.modules.opensign.vo.request.ru;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: StartDeleteFileRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: StartDeleteFileRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("发起前-删除文件-请求对象")
public class StartDeleteFileRequest implements Serializable {

    private static final long serialVersionUID = -3585489862047095369L;

    // @ApiModelProperty("文件id")
    private String fileId ;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;
}