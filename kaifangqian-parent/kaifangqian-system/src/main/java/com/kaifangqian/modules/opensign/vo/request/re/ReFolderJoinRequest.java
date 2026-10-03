/**
 * @description 业务线文件夹添加业务线-请求对象
 */
package com.kaifangqian.modules.opensign.vo.request.re;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: ReFolderJoinRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: ReFolderJoinRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("业务线文件夹添加业务线-请求对象")
public class ReFolderJoinRequest implements Serializable {

    // @ApiModelProperty("文档夹主键")
    private String folderId ;
    // @ApiModelProperty("模板id列表")
    private List<String> ids ;


}