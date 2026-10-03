/**
 * @description 签署文件获取方式类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignerTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignerTypeEnum
 * @author: FengLai_Gong
 */
public enum SignFileTypeEnum {


    UPLOAD(1,"上传"),
    TEMPLATE(2,"模板"),

    ;
    private Integer code  ;

    private String name ;

    SignFileTypeEnum(Integer code, String name){
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