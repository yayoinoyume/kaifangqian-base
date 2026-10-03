package com.kaifangqian.modules.opensign.vo.request;

import com.kaifangqian.modules.opensign.vo.base.TemplateAuthVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TemplateEditRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: TemplateEditRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模板编辑请求对象")
public class TemplateEditRequest implements Serializable {

    private static final long serialVersionUID = 390637053443014670L;

    // @ApiModelProperty("模板id")
    private String templateId ;

    // @ApiModelProperty("模板名称")
    private String templateName ;

    // @ApiModelProperty("业务类型字典id")
    private String businessType ;

    // @ApiModelProperty("备注")
    private String note ;

    // @ApiModelProperty("模板权限数据列表")
    private List<TemplateAuthVo> authVoList ;

}