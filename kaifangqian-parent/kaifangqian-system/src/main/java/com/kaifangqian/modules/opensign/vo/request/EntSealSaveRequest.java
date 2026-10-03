package com.kaifangqian.modules.opensign.vo.request;

import com.kaifangqian.modules.opensign.vo.base.BusinessAuthVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: EntSealSaveRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: EntSealSaveRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("印章新增请求对象")
public class EntSealSaveRequest implements Serializable {


    private static final long serialVersionUID = -262548305395622229L;


    // @ApiModelProperty("企业签章id")
    private String sealId;

    // @ApiModelProperty("企业签章申请记录id")
    private String sealApplyId;

    // @ApiModelProperty("印章管理员id，印章所属系统租户下用户id")
    private String adminId ;

    // @ApiModelProperty("印章名称")
    private String sealName ;

    // @ApiModelProperty("印章样式（1、公章；2、圆形章；3、椭圆形；）")
    private Integer sealStyle ;

    // @ApiModelProperty("印章类型（1、公章；2、财务专用章；3、合同专用章；4、人事专用章；5、其他）")
    private Integer sealType ;

    // @ApiModelProperty("创建类型（1、模板创建；2、上传创建）")
    private Integer createType ;

    // @ApiModelProperty("印章状态（制作中、制作失败、已停用、已启用、已收缴、已销毁）")
    private Integer sealStatus ;

    // @ApiModelProperty("申请状态（待提交、待重新提交、待审批、审批未通过、审批通过、作废）")
    private Integer applyStatus ;

    // @ApiModelProperty("颜色(1、红色；2、蓝色；3、黑色)")
    private Integer color ;

    // @ApiModelProperty("上排环绕文字")
    private String topText ;

    // @ApiModelProperty("横排文字',")
    private String middleText ;

    // @ApiModelProperty("下弦文")
    private String bottomText ;

    // @ApiModelProperty("用途说明")
    private String description ;

    // @ApiModelProperty("文件id")
    private String annexId;

    // @ApiModelProperty("签章图片base64")
    private String sealBase64;

    // @ApiModelProperty("印章管理员列表")
    private List<BusinessAuthVo> managerList ;

    // @ApiModelProperty("印章使用者列表")
    private List<BusinessAuthVo> userList ;

    // @ApiModelProperty("印章审计者列表")
    private List<BusinessAuthVo> auditorList ;


}