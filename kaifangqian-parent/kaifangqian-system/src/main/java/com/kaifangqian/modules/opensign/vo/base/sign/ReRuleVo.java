/**
 * @description 业务线配置-单号生成规则-数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: ReRuleVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: ReRuleVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线配置-单号生成规则-数据对象")
public class ReRuleVo implements Serializable {

    private static final long serialVersionUID = 3539791966124117960L;

    // @ApiModelProperty("'主键'")
    private String id ;

    // @ApiModelProperty("业务线主表id")
    private String signReId ;


    // @ApiModelProperty("'业务规则类型,1文件编号,2文件主题'")
    private Integer ruleType ;

    // @ApiModelProperty("'规则生成id'")
    private String ruleGenerateId ;

    // @ApiModelProperty("'连接字段'")
    private String link ;

    // @ApiModelProperty("单号生成规则细节列表数据")
    private List<ReRuleDetailVo> detailVoList ;


}