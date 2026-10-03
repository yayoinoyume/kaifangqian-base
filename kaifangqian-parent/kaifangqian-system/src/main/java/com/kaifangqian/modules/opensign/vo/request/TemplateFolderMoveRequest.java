package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TemplateFolderDeleteRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: TemplateFolderDeleteRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模板文件夹移动模板请求对象")
public class TemplateFolderMoveRequest implements Serializable {


    private static final long serialVersionUID = -8750891449077539792L;

//    // @ApiModelProperty("源文档夹主键")
//    private String sourceFolderId ;
    // @ApiModelProperty("目标档夹主键")
    private String targetFolderId ;
    // @ApiModelProperty("模板id列表")
    private List<String> ids ;


}