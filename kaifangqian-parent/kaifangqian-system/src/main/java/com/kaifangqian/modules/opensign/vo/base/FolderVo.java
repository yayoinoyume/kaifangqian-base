/**
 * @description 文件夹-信息数据
 */
package com.kaifangqian.modules.opensign.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: FolderVO
 * @Package: com.kaifangqian.modules.opensign.vo.base
 * @ClassName: FolderVO
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("文件夹-信息数据")
public class FolderVo implements Serializable {


    private static final long serialVersionUID = 3448150876546873440L;

    // @ApiModelProperty("文件夹主键")
    private String  id ;
    // @ApiModelProperty("父文件夹id")
    private String parentFolderId ;
    // @ApiModelProperty("文件夹名称")
    private String name ;

    // @ApiModelProperty("子列表")
    private List<FolderVo> children ;
}