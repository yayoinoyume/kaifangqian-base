package com.kaifangqian.modules.opensign.vo.response.ru;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: InfoLinkResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response.ru
 * @ClassName: InfoLinkResponse
 * @author: FengLai_Gong
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
//@ApiModel("业务线实例-短信链接数据详情-返回数据")
public class SignRuSignerResponse implements Serializable {

    private static final long serialVersionUID = -8227874145137753158L;

//    @ApiModelProperty("'签署方类型，1发起方，2外部个人接收方 3外部企业接收方'")
    private Integer signerType ;

//    @ApiModelProperty("'签署方名称'")
    private String signerName ;






}