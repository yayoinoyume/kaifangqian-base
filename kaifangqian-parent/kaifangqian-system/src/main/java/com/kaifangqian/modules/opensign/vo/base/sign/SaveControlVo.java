/**
 * @description 控件保存-请求对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: SaveControlVo
 * @Package: com.kaifangqian.modules.opensign.vo.base.sign
 * @ClassName: SaveControlVo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("控件保存-请求对象")
public class SaveControlVo implements Serializable {

    private static final long serialVersionUID = 1449590675277315939L;

    // @ApiModelProperty("签署控件数据")
    private List<DocControlVo> controlList ;

    // @ApiModelProperty("删除控件id列表数据")
    private List<String> deleteIdList ;

    // @ApiModelProperty("控件变更状态")
    private String controlChangeFlag ;
}