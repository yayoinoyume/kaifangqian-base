package com.kaifangqian.modules.opensign.vo.response.re;

import com.fasterxml.jackson.annotation.JsonFormat;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description: ListReponse
 * @Package: com.kaifangqian.modules.opensign.vo.response.re
 * @ClassName: ListReponse
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("业务线配置列表-返回对象")
public class ListResponse implements Serializable {

    private static final long serialVersionUID = 989711067561773123L;

    // @ApiModelProperty("业务线id")
    private String id ;

    // @ApiModelProperty("业务线名称")
    private String name ;

    // @ApiModelProperty("管理员列表")
    private List<String> managerList ;

    // @ApiModelProperty("'异常状态，1为启用，2为停用'")
    private Integer status ;

    // @ApiModelProperty("更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate ;

    // @ApiModelProperty("'异常状态，1为是，2为否'")
    private Integer errorStatus ;

    // @ApiModelProperty("所属文件夹名称（类型名称）")
    private String folderName ;

}