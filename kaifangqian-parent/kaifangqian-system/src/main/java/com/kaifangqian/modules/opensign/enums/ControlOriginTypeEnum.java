/**
 * @description 补充控件来源类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: ControlOriginTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: ControlOriginTypeEnum
 * @author: FengLai_Gong
 */
public enum ControlOriginTypeEnum {


    RE(1,"业务线"),
    START(2,"发起时设置"),
    OPERATION(3,"操作时设置"),
    ;

    private Integer code  ;

    private String name ;

    ControlOriginTypeEnum(Integer code, String name){
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