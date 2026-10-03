package com.kaifangqian.modules.opensign.vo.request;

import com.kaifangqian.modules.opensign.vo.base.TemplateControlVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TemplateSaveControlLIstRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: TemplateSaveControlLIstRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模板保存控件请求对象")
public class TemplateSaveControlListRequest implements Serializable {

    private static final long serialVersionUID = -5774204742582439923L;

    // @ApiModelProperty("模板id，可以不传")
    private String templateId ;
    // @ApiModelProperty("模板申请记录id,必传参数")
    private String templateApplyId ;
    // @ApiModelProperty("模板控件列表")
    private List<TemplateControlVo> controlVoList ;
}