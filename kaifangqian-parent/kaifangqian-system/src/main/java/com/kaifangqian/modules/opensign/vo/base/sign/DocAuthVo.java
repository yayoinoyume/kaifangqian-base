/**
 * @description 业务线权限数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: DocAuthVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: DocAuthVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线权限数据对象")
public class DocAuthVo implements Serializable {

    private static final long serialVersionUID = -8424711342822876099L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("'业务线实例主表id'")
    private String signRuId ;


    // @ApiModelProperty("'权限类型，1管理员，2使用范围，3查看权限，4下载权限'")
    private Integer authType ;

    // @ApiModelProperty("'用户类型'")
    private Integer userType ;

    // @ApiModelProperty("'用户id'")
    private String userId ;

    // @ApiModelProperty("'用户名称'")
    private String userName ;


}