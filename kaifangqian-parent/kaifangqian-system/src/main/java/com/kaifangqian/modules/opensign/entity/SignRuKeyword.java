/**
 * @description 业务线实例-关键字设置
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignRuKeyword
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignRuKeyword
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_ru_keyword")
// @ApiModel("业务线实例-关键字设置")
public class SignRuKeyword implements Serializable {

    private static final long serialVersionUID = 4858761406078014835L;

    // @ApiModelProperty("主键")
    private String id ;

    // @ApiModelProperty("业务线实例id")
    private String ruId ;

    // @ApiModelProperty("签署方id，signerId或者senderId")
    private String signerId ;

    // @ApiModelProperty("关键字内容")
    private String keyword ;

    // @ApiModelProperty("横坐标偏移量")
    private String offsetX ;

    // @ApiModelProperty("纵坐标偏移量")
    private String offsetY ;
}