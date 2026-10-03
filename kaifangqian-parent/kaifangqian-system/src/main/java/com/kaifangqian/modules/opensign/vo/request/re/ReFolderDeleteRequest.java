/**
 * @description 业务线文件夹删除请求对象
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
 * @Description: ReFolderDeleteRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: ReFolderDeleteRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("业务线文件夹删除请求对象")
public class ReFolderDeleteRequest implements Serializable {

    // @ApiModelProperty("文件id列表")
    private List<String> folderIdList ;


}