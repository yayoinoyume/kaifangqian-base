/**
 * @description 签署业务线权限枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignReAuthTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignReAuthTypeEnum
 * @author: FengLai_Gong
 */
public enum SignReAuthTypeEnum {

    MANAGER(1,"管理者"),
    USER(2,"使用者"),
    VIEWER(3,"查看者"),
    DOWNLOADER(4,"下载者"),
    ;

    private Integer code  ;

    private String name ;

    SignReAuthTypeEnum(Integer code, String name){
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