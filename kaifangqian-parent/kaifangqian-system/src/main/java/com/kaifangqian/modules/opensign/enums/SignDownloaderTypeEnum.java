/**
 * @description 文档下载权限操作人角色类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: SignDownloaderTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignDownloaderTypeEnum
 * @author: FengLai_Gong
 */
public enum SignDownloaderTypeEnum {


    PARTICIPANTS(1,"参与人"),
    VIEWER(2,"查看人"),
    ALL(3,"全部"),
    ;

    private Integer code  ;

    private String name ;

    SignDownloaderTypeEnum(Integer code, String name){
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