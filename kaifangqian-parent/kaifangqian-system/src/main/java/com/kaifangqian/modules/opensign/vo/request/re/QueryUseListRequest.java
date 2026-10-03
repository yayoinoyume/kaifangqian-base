/**
 * @description 分页查询对象
 */
package com.kaifangqian.modules.opensign.vo.request.re;

// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * @Description: QueryUseListRequest
 * @Package: com.kaifangqian.modules.opensign.vo.request.re
 * @ClassName: QueryUseListRequest
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryUseListRequest implements Serializable {

    // @ApiModelProperty("名称")
    private String name ;

    // @ApiModelProperty("状态")
    private Integer status ;

    // @ApiModelProperty("文件夹ID")
    private String folderId;

    // @ApiModelProperty("页码")
    private Integer pageNo = 1;

    // @ApiModelProperty("页码大小")
    private Integer pageSize = 10 ;

}