/**
 * @description 印章审计对象
 */
package com.kaifangqian.modules.opensign.dto;

// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: UseSealAuditDto
 * @Package: com.kaifangqian.modules.opensign.service.cert
 * @ClassName: UseSealAuditDto
 * @author: Fusion
 * CreateTime:  2023/8/18  15:50
 * @copyright 本平台运营方
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ApiModel("印章审计对象")
public class SealAuditDto {

    // @ApiModelProperty(value = "印章名称")
    private String sealName;     //印章名称

    // @ApiModelProperty(value = "印章类型")
    private Integer sealType;    //印章类型


}
