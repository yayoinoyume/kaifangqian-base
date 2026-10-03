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
// @ApiModel("模板文件夹删除请求对象")
public class TemplateFolderDeleteRequest implements Serializable {


    private static final long serialVersionUID = -8750891449077539792L;

    // @ApiModelProperty("文件id列表")
    private List<String> folderIdList ;
}