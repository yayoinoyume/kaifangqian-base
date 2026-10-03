/**
 * @description 模板状态类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: TemplateStatusEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: TemplateStatusEnum
 * @author: FengLai_Gong
 */
public enum TemplateStatusEnum {

    MAKING(1,"制作中"),

    MAKE_FAILED(2,"制作失败"),

    UN_ENABLED(3,"已停用"),

    ENABLED(4,"已启用"),

    ;


    TemplateStatusEnum(Integer code ,String name){
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