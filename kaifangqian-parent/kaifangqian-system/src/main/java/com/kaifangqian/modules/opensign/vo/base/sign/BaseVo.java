/**
 * @description 业务线基础数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: BaseVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: BaseVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线基础数据对象")
public class BaseVo implements Serializable {


    private static final long serialVersionUID = -2766262946312521349L;

    // @ApiModelProperty("业务线主数据")
    private DocBaseVo baseVo ;

    // @ApiModelProperty("签约方列表数据")
    private List<DocSignerVo> signerList ;

    // @ApiModelProperty("抄送方列表数据")
    private List<DocCcerVo> ccerList ;

    // @ApiModelProperty("审批相关列表")
    private List<DocApproveVo> approveList ;

    // @ApiModelProperty("签约文件列表")
    private List<DocFileVo> fileList ;

    // @ApiModelProperty("签约文件-附件列表")
    private List<DocOtherFileVo> otherFileList ;

    // @ApiModelProperty("发起人id")
    private String startUserId ;

    // @ApiModelProperty("发起人名称")
    private String startUserName ;


}