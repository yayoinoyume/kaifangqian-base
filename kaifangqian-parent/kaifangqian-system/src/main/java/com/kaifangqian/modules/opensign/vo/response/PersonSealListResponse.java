package com.kaifangqian.modules.opensign.vo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: PersonSealListResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response
 * @ClassName: PersonSealListResponse
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("个人签名列表返回对象")
public class PersonSealListResponse implements Serializable {

    private static final long serialVersionUID = -8088075226509260971L;

    // @ApiModelProperty("签名id")
    private String sealId ;

    // @ApiModelProperty("文件id")
    private String annexId ;

    // @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime ;

    // @ApiModelProperty("签名名称")
    private String sealName ;

    // @ApiModelProperty("是否为默认，1为默认，2为非默认")
    private Integer isDefault ;
}