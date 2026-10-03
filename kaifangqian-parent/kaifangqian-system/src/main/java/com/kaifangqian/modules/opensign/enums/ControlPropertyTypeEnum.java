/**
 * @description 控件属性类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 控件属性类型枚举
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: ControlPropertyTypeEnum
 * @author: FengLai_Gong
 */
public enum ControlPropertyTypeEnum {

    RELATION_DOC("relation_doc","控件属性-应用文档") ,
    PAGE_CONFIG("page_config","控件属性-应用页面") ,


    ;

    private String  code  ;

    private String name ;

    ControlPropertyTypeEnum(String code, String name){
        this.code = code ;
        this.name = name;
    }


    public String getCode(){
        return this.code;
    }

    public String getName(){
        return this.name ;
    }





}