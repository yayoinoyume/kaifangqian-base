/**
 * @description 代办任务链接
 */
package com.kaifangqian.modules.api.vo.response;

// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: PageUrlResponse
 * @Package: com.kaifangqian.modules.api.vo.response
 * @ClassName: PageUrlResponse
 * @author: FengLai_Gong
 */
@Data
public class PageUrlResponse implements Serializable {

    private static final long serialVersionUID = 3752824847121503501L;

    // @ApiModelProperty("链接URL")
    private String pageUrl ;
}