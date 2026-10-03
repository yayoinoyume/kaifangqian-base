/**
 * @description 业务线抄送人数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: DocCcerVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: DocCcerVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线抄送人数据对象")
public class DocCcerVo implements Serializable {

    private static final long serialVersionUID = -1675294042526285814L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;

    // @ApiModelProperty("'新增抄送人类型，1业务线配置，2用户新增'")
    private Integer ccerAddType ;

    // @ApiModelProperty("'抄送人类型，1内部，2外部'")
    private Integer ccerType ;

    // @ApiModelProperty("'内部抄送人租户下用户id'")
    private String internalCcerId ;

    // @ApiModelProperty("'内部抄送人租户下用户名称'")
    private String internalCcerName ;



    // @ApiModelProperty("'外部抄送人名称'")
    private String externalCcerName ;

    // @ApiModelProperty("'外部抄送人抄送类型，1手机号，2邮箱号'")
    private Integer externalCcedType ;

    // @ApiModelProperty("'外部抄送人抄送值'")
    private String externalCcedValue ;


}