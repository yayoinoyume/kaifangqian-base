package com.kaifangqian.modules.opensign.vo.response;

import com.kaifangqian.modules.opensign.vo.base.BusinessAuthVo;
import com.kaifangqian.modules.opensign.vo.base.ImageVo;
import com.kaifangqian.modules.opensign.vo.base.TemplateControlVo;
import com.kaifangqian.modules.opensign.vo.base.TemplateInfo;
import com.kaifangqian.modules.opensign.vo.base.*;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TemplateInfoResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response
 * @ClassName: TemplateInfoResponse
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模板详情返回对象")
public class TemplateInfoResponse implements Serializable {

    private static final long serialVersionUID = -817868828033884760L;

    // @ApiModelProperty("模板主数据")
    private TemplateInfo templateVo;
    // @ApiModelProperty("模板控件数据")
    private List<TemplateControlVo> templateControlVoList ;
    // @ApiModelProperty("模板图片数据")
    private List<ImageVo> imageVoList ;

//    // @ApiModelProperty("模板权限数据列表")
//    private List<TemplateAuthVo> authVoList ;

    // @ApiModelProperty("印章管理员列表")
    private List<BusinessAuthVo> managerList ;

    // @ApiModelProperty("印章使用者列表")
    private List<BusinessAuthVo> userList ;

}