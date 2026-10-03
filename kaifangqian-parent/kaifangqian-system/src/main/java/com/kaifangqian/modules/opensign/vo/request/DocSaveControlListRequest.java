package com.kaifangqian.modules.opensign.vo.request;

import com.kaifangqian.modules.opensign.vo.base.DocControlVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: DocSaveRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: DocSaveRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("文档保存控件请求对象")
public class DocSaveControlListRequest implements Serializable {


    private static final long serialVersionUID = 8824276846304294304L;

    // @ApiModelProperty("文档主数据")
    private String docId ;
    // @ApiModelProperty("文档控件列表数据")
    private List<DocControlVo> docControlVoList ;
}