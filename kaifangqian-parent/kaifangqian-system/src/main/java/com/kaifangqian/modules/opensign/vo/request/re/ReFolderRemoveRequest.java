package com.kaifangqian.modules.opensign.vo.request.re;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: ReFolderRemoveRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: ReFolderRemoveRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("业务线文件夹移除模板请求对象")
public class ReFolderRemoveRequest implements Serializable {

    // @ApiModelProperty("文档夹主键")
    private String folderId ;
    // @ApiModelProperty("业务线id列表")
    private List<String> ids ;


}