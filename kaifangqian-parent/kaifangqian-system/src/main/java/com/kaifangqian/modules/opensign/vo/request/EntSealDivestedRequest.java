package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: EntSealEnabled
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: EntSealEnabled
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("印章收缴请求对象")
public class EntSealDivestedRequest implements Serializable {

    private static final long serialVersionUID = 6345480332061395183L;

    // @ApiModelProperty("签章id")
    private String sealId ;
}