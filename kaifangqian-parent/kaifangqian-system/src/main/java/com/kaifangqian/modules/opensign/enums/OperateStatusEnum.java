/**
 * @description 操作状态枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: OperateStatusEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: OperateStatusEnum
 * @author: FengLai_Gong
 */
public enum OperateStatusEnum {


    NO_NEED_FINISH(0,"不需要"),
    NOT_FINISHED(1,"未完成"),
    WAIT_TO_FINISH(2,"待完成"),
    FINISHED(3,"已完成"),
    REJECT(4,"已拒绝"),


    ;

    private Integer code  ;

    private String name ;

    OperateStatusEnum(Integer code, String name){
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