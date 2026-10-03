/**
 * @description 业务线权限-请求对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: ReAuthVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: ReAuthVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线权限-请求对象")
public class ReAuthVo implements Serializable {

    private static final long serialVersionUID = 3432579867206176602L;

    // @ApiModelProperty("权限数据列表")
    private List<DocAuthVo> authList ;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;

    // @ApiModelProperty("'下载权限类型，1参与人，2查看人，3全部'")
    private Integer downloaderType ;




}