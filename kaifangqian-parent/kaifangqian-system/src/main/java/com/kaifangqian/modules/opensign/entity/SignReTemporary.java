/**
 * @description 临时签约文件表
 */
package com.kaifangqian.modules.opensign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaifangqian.common.base.entity.BaseEntity;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SignReTemporary
 * @Package: com.kaifangqian.modules.opensign.entity
 * @ClassName: SignReTemporary
 * @author: FengLai_Gong
 */
@Data
@TableName("sign_re_temporary")
// @ApiModel("临时签约文件表")
public class SignReTemporary extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5476424989601244293L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("'业务线配置主表id'")
    private String signReId ;

    // @ApiModelProperty("'文件名称'")
    private String name ;

    // @ApiModelProperty("'真实文件id'")
    private String annexId ;


}