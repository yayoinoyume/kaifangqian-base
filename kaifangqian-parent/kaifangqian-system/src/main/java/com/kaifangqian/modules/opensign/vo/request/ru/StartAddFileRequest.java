package com.kaifangqian.modules.opensign.vo.request.ru;

import com.kaifangqian.modules.opensign.vo.base.sign.DocFileVo;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: StartAddFileRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.ru
 * @ClassName: StartAddFileRequest
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("发起前-添加文件-请求对象")
public class StartAddFileRequest implements Serializable {


    private static final long serialVersionUID = 6890793896581859354L;

    // @ApiModelProperty("文件对象")
    private DocFileVo fileVo ;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;

}