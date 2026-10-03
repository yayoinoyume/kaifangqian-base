/**
 * @description 业务线签约文件删除-请求对象
 */
package com.kaifangqian.modules.opensign.vo.request.re;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: DeleteFileRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: DeleteFileRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线签约文件删除-请求对象")
public class DeleteFileRequest implements Serializable {

    private static final long serialVersionUID = -7653129253374660504L;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("业务线签约文件")
    private String fileId ;

}