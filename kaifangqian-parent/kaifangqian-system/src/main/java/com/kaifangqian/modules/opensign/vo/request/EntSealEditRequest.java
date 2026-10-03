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
public class EntSealEditRequest implements Serializable {


    private static final long serialVersionUID = -262548305395622229L;


    // @ApiModelProperty("主键")
    private String id;

    // @ApiModelProperty("印章管理员id，印章所属系统租户下用户id")
    private String adminId ;

    // @ApiModelProperty("印章名称")
    private String sealName ;

    // @ApiModelProperty("印章类型（1、公章；2、财务专用章；3、合同专用章；4、人事专用章；5、其他）")
    private Integer sealType ;

    // @ApiModelProperty("用途说明")
    private String description ;


    // @ApiModelProperty("印章管理员列表")
    private List<BusinessAuthVo> managerList ;

    // @ApiModelProperty("印章使用者列表")
    private List<BusinessAuthVo> userList ;

    // @ApiModelProperty("印章审计者列表")
    private List<BusinessAuthVo> auditorList ;



}