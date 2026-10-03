package com.kaifangqian.modules.opensign.vo.response;

import com.kaifangqian.modules.opensign.vo.base.DocControlVo;
import com.kaifangqian.modules.opensign.vo.base.DocInfo;
import com.kaifangqian.modules.opensign.vo.base.ImageVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: DocInfoResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response
 * @ClassName: DocInfoResponse
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("文档详情返回对象")
public class DocInfoResponse implements Serializable {


    // @ApiModelProperty("文档主数据")
    private DocInfo docVo ;
    // @ApiModelProperty("文档控件列表数据")
    private List<DocControlVo> docControlVoList ;
    // @ApiModelProperty("文档图片数据")
    private List<ImageVo> imageVoList ;




}