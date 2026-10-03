package com.kaifangqian.modules.opensign.vo.request.re;

import com.kaifangqian.modules.opensign.vo.base.sign.*;
import com.kaifangqian.modules.opensign.vo.base.sign.*;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: SaveBaseRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: SaveBaseRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线配置保存-请求对象")
public class SaveBaseRequest implements Serializable {

    private static final long serialVersionUID = -497181493953194851L;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("基础数据")
    private DocBaseVo base ;

    // @ApiModelProperty("签约文件列表")
    private List<DocFileVo> fileList ;

    // @ApiModelProperty("签约文件-附件列表")
    private List<DocOtherFileVo> otherFileList ;

    // @ApiModelProperty("签署人数据（内部签署设置数据）")
    private List<DocSignerVo> signerList ;

    // @ApiModelProperty("抄送人数据")
    private List<DocCcerVo> ccerList ;

}