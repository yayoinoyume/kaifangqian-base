package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TemplateSubmitReuqest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: TemplateSubmitReuqest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("模板发布请求对象")
public class TemplateSubmitRequest implements Serializable {

    private static final long serialVersionUID = 9025896300737911395L;

    // @ApiModelProperty("模板id")
    private String id ;


}