/**
 * @description 签署发起方式枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignerTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignerTypeEnum
 * @author: FengLai_Gong
 */
public enum SignOriginTypeEnum {


    RE(1,"业务线"),
    UPLOAD(2,"自行上传"),

    ;
    private Integer code  ;

    private String name ;

    SignOriginTypeEnum(Integer code, String name){
        this.code = code ;
        this.name = name;
    }


    public Integer getCode(){
        return this.code;
    }

    public String getName(){
        return this.name ;
    }
}