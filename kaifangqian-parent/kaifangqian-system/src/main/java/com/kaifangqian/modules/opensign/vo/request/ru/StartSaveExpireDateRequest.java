package com.kaifangqian.modules.opensign.vo.request.ru;

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
 * @Description: StartSaveExpireDateRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: StartSaveExpireDateRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("业务线实例-发起前-更新实例签署截止时间")
public class StartSaveExpireDateRequest implements Serializable {


    private static final long serialVersionUID = -6646251532543682268L;

    // @ApiModelProperty("业务线实例id")
    private String signRuId ;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @ApiModelProperty("'签署截止时间'")
    private Date expireDate ;



}