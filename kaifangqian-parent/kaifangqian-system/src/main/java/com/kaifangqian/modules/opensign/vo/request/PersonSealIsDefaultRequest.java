package com.kaifangqian.modules.opensign.vo.request;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: PersonSealIsDefaultRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request
 * @ClassName: PersonSealIsDefaultRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("设置个人签名为默认-请求对象")
public class PersonSealIsDefaultRequest implements Serializable {


    private static final long serialVersionUID = 6728148401920851397L;
    // @ApiModelProperty("签名id")
    private String sealId ;
}