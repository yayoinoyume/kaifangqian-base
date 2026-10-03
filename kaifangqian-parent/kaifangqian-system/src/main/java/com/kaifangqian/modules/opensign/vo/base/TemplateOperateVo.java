/**
 * @description 模板操作返回对象
 */
package com.kaifangqian.modules.opensign.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TemplateOperateVo
 * @Package: com.kaifangqian.modules.opensign.vo.base
 * @ClassName: TemplateOperateVo
 * @author: FengLai_Gong
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模板操作返回对象")
public class TemplateOperateVo implements Serializable {

    private static final long serialVersionUID = -1019692652553557991L;

    // @ApiModelProperty("模板申请记录id")
    private String templateApplyId;

    // @ApiModelProperty("模板id")
    private String templateId;

}