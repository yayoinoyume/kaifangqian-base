/**
 * @description 控件签署应用范围枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: KeywordSearchTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: KeywordSearchTypeEnum
 * @author: FengLai_Gong
 */
public enum KeywordPropertyEnum {

    RELATION_DOC("relation_doc","控件属性-应用文档") ,
    PAGE_CONFIG("page_config","控件属性-应用页面") ,

    ALl("all","全部"),
    PART("part","部分"),

    ASC("asc","正序"),
    DESC("desc","倒序"),

    CUSTOM("custom","指定位"),

    ;


    private String  code  ;

    private String name ;

    KeywordPropertyEnum(String code, String name){
        this.code = code ;
        this.name = name;
    }


    public String getCode(){
        return this.code;
    }

    public String getName(){
        return this.name ;
    }

    public static KeywordPropertyEnum getValue(String code){
        KeywordPropertyEnum[] values = KeywordPropertyEnum.values();
        for(KeywordPropertyEnum keywordSearchTypeEnum : values){
            if(keywordSearchTypeEnum.getCode().equals(code)){
                return keywordSearchTypeEnum ;
            }
        }
        return null ;
    }
}