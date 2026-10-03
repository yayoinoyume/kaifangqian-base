/**
 * @description 文档签署操作类型枚举类
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 签署操作类型枚举
 * @Package: com.kaifangqian.modules.sign.enums
 * @ClassName: SignDocOperateEnum
 * @author: FengLai_Gong
 */
public enum SignDocOperateRecordEnum {


    INIT(0,"初始"),
    WRITE(1,"填写"),
    SIGN(2,"签署"),


    ;
    private Integer code  ;

    private String name ;

    SignDocOperateRecordEnum(Integer code, String name){
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