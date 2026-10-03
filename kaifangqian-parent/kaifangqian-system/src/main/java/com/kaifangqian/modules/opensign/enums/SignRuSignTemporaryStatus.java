/**
 * @description 签署办理状态类型
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignRuSignTemporaryStatus
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignRuSignTemporaryStatus
 * @author: FengLai_Gong
 */
public enum SignRuSignTemporaryStatus {


    PROGRESSING(0,"进行中"),
    FINISHED(1,"已完结"),

    ;
    private Integer code  ;

    private String name ;

    SignRuSignTemporaryStatus(Integer code, String name){
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