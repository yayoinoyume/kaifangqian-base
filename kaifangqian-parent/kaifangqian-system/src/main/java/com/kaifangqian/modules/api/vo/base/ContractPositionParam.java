/**
 * @description API接口合同签署控件对象
 */
package com.kaifangqian.modules.api.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: ContractControl
 * @Package: com.kaifangqian.modules.api.vo.base
 * @ClassName: ContractControl
 * @author: FengLai_Gong
 * @Date: 2024/03/17
 */
@Data
// @ApiModel("签署位置合集")
public class ContractPositionParam implements Serializable {

    private static final long serialVersionUID = 6079865233861463014L;


    // @ApiModelProperty("签署控件类型,个人签章SIGNATURE,企业签章SEAL,签署日期SIGN_DATE,骑缝签CHOP_STAMP")
    private String controlType ; ;

    // @ApiModelProperty("签署位置设置方式,位置POSITION,关键字KEYWORD")
    private String signPositionType ;

    // @ApiModelProperty("关联文档列表")
    private List<ContractRelationDoc> relationDocList ;

    // @ApiModelProperty("签署时间格式,默认为YEAR_MONTH_DAY格式为yyyy年MM月dd日，LINE格式为yyyy-MM-dd，BACK_SLASH格式为yyyy/MM/dd")
    private String signDateFormat ;

    // @ApiModelProperty("页码配置，全部页ALL，偶数页EVEN_NUMBER，奇数页ODD_NUMBER，指定页码1,2,7-10")
    private String pageConfig ;

    // @ApiModelProperty("关键字")
    private String keyword ;

    // @ApiModelProperty("1代表第1个关键字，0代表所有关键字，-1代表倒数第1个关键字；默认为1")
    private String keywordType ;

    // @ApiModelProperty("横坐标/关键字-偏移量")
    private String offsetX ;

    // @ApiModelProperty("纵坐标/关键字-偏移量")
    private String offsetY ;

    // @ApiModelProperty("签章位置宽度")
    private String controlWidth ;

    // @ApiModelProperty("签章位置高度")
    private String controlHeight ;

}