/**
 * @description 操作角色类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: RelationTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: RelationTypeEnum
 * @author: FengLai_Gong
 */
public enum RelationTypeEnum {

    SENDER(1,"发起人"),
    CCER(2,"抄送人"),

    ;

    private Integer code  ;

    private String name ;

    RelationTypeEnum(Integer code, String name){
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