/**
 * @description 印章状态枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: EntSealStatusEnums
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: EntSealStatusEnums
 * @author: FengLai_Gong
 */
public enum EntSealStatusEnum {


    MAKING(1,"制作中"),

    MAKE_FAILED(2,"制作失败"),

    UN_ENABLED(3,"已停用"),

    ENABLED(4,"已启用"),

    DIVESTED(5,"已收缴"),

    DESTRUCTION(6,"已销毁"),

    ;
    EntSealStatusEnum(Integer code ,String name){
        this.code = code;
        this.name = name;
    }

    private Integer code ;
    private String name ;

    public String getName(){
        return this.name;
    }

    public Integer getCode(){
        return this.code;
    }



}