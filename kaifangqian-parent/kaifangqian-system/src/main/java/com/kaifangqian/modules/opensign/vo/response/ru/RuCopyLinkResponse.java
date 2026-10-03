package com.kaifangqian.modules.opensign.vo.response.ru;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 签署实例复制链接数据详情-返回数据
 * @Package: com.kaifangqian.modules.opensign.vo.response.ru
 * @ClassName: RuCopyLinkResponse
 * @author: FengLai_Gong
 */
@Data
public class RuCopyLinkResponse implements Serializable {

    private static final long serialVersionUID = -6987020525021675611L;

    // @ApiModelProperty("任务id")
    private String taskId ;
    // @ApiModelProperty("手机号")
    private String phone ;
    // @ApiModelProperty("邮箱")
    private String email ;

}