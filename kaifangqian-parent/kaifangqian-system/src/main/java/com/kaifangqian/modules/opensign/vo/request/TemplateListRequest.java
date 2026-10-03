package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TemplateListRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: TemplateListRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模板列表请求对象")
public class TemplateListRequest implements Serializable {

    private static final long serialVersionUID = 9083164806133819515L;

    // @ApiModelProperty("模板文件夹")
    private String templateFolderId;

    // @ApiModelProperty("模板编号")
    private String templateCode ;

    // @ApiModelProperty("模板名称")
    private String templateName ;

    // @ApiModelProperty("业务类型字典id")
    private String businessType ;

    // @ApiModelProperty("模板类型（1、有参数模板；2、无参数模板；")
    private Integer templateType ;

    // @ApiModelProperty("模板状态（制作中、制作失败、已停用、已启用）")
    private Integer templateStatus ;

    // @ApiModelProperty("页码")
    Integer pageNo = 1;

    // @ApiModelProperty("页码大小")
    Integer pageSize = 10 ;

}