/**
 * @description API接口合同关联文件对象
 */
package com.kaifangqian.modules.api.vo.base;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: ContractRelationDoc
 * @Package: com.kaifangqian.modules.api.vo.base
 * @ClassName: ContractRelationDoc
 * @author: FengLai_Gong
 * @Date: 2024/3/17
 */
@Data
// @ApiModel("关联文档")
public class ContractRelationDoc implements Serializable {

    private static final long serialVersionUID = -8666551221041637138L;

    // @ApiModelProperty("文件类型，本地文件/模板文件")
    private String docType ;

    // @ApiModelProperty("文件id")
    private String docId ;



}