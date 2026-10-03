/**
 * @description 模板数据
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
 * @Description: TemplateVo
 * @Package: com.kaifangqian.modules.opensign.vo.base
 * @ClassName: TemplateVo
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模板数据")
public class TemplateVo implements Serializable {

    private static final long serialVersionUID = -2494082873157926125L;

    // @ApiModelProperty("模板id")
    private String templateId;

    // @ApiModelProperty("模板申请记录id")
    private String templateApplyId;

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
    private String annexId ;

    // @ApiModelProperty("是否提交，1为提交，2为否")
    private Integer submitFlag ;


//    // @ApiModelProperty("模板权限数据列表")
//    private List<TemplateAuthVo> authVoList ;

    // @ApiModelProperty("印章管理员列表")
    private List<BusinessAuthVo> managerList ;

    // @ApiModelProperty("印章使用者列表")
    private List<BusinessAuthVo> userList ;

}