/**
 * @description 个人账号的注册和实名请求对象
 */
package com.kaifangqian.modules.api.vo.request;

import com.kaifangqian.modules.api.base.ReqBaseVO;
import com.kaifangqian.modules.api.vo.base.ContractUser;
// import io.swagger.annotations.ApiModel;
// import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: PersonCreateAndAuthRequest
 * @Package: com.kaifangqian.modules.api.vo.request
 * @ClassName: PersonCreateAndAuthRequest
 * @author: FengLai_Gong
 * @Date: 2024/3/14
 */
@Data
// @ApiModel("个人账号的注册和实名请求对象")
public class PersonCreateAndAuthRequest extends ReqBaseVO implements Serializable {

    private static final long serialVersionUID = 3456070310036219268L;

    // @ApiModelProperty("账号")
//    @ContractUserValid(groups = ValidationSorts.SortA1.class)
    private ContractUser account ;

    // @ApiModelProperty("个人/法人证件类型，\n" +
//            "1.中国居民身份证\n" +
//            "2.港澳居民居住证\n" +
//            "3.台湾居民居住证\n" +
//            "4.港澳居民来往内地通行证（即：回乡证）\n" +
//            "5.台湾居民来往大陆通行证（即：台胞证）\n" +
//            "6.外国人永久居留居住证（即：中国绿卡、永居证）\n" +
//            "7.国际护照")
    private Integer idCardType;

    // @ApiModelProperty("身份证号")
    private String identity ;

    // @ApiModelProperty("手机号")
    private String mobile;

    // @ApiModelProperty("银行卡")
    private String bankCard;


//    // @ApiModelProperty("手机号")
//    private String mobile ;


}