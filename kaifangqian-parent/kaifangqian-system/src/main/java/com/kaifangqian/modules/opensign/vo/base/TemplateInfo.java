/**
 * @description 模板数据
 */
package com.kaifangqian.modules.opensign.vo.base;

import com.kaifangqian.modules.storage.entity.AnnexStorage;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TemplateVo
 * @Package: com.kaifangqian.modules.opensign.vo.base
 * @ClassName: TemplateVo
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模板数据")
public class TemplateInfo implements Serializable {

    private static final long serialVersionUID = -2494082873157926125L;

    // @ApiModelProperty("模板id")
    private String templateId;

    // @ApiModelProperty("模板申请id")
    private String templateApplyId ;

    // @ApiModelProperty("模板编号")
    private String templateCode ;

    // @ApiModelProperty("模板名称")
    private String templateName ;

    // @ApiModelProperty("业务类型字典id")
    private String businessType ;

    // @ApiModelProperty("模板类型（1、有参数模板；2、无参数模板；")
    private Integer templateType ;

    // @ApiModelProperty("签章id")
    private String sealId ;

    // @ApiModelProperty("备注")
    private String note ;

    // @ApiModelProperty("模板状态（制作中、制作失败、已停用、已启用）")
    private Integer templateStatus ;

    // @ApiModelProperty("申请状态（待提交、待重新提交、待审批、审批未通过、审批通过、作废）")
    private Integer applyStatus ;

    // @ApiModelProperty("文件id")
    private AnnexStorage annex ;



}