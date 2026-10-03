/**
 * @description 签署文件类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: SignFileSuffixEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignFileSuffixEnum
 * @author: FengLai_Gong
 */
public enum SignFileSuffixEnum {

    DOC(".doc",""),
    DOCX(".docx",""),
    WPS(".wps",""),
    JPG(".jpg",""),
    PNG(".png",""),
    PDF(".pdf",""),
    XLSX(".xlsx",""),
    ZIP(".zip",""),
    RAR(".rar",""),



    ;


    private String  type  ;

    private String name ;

    SignFileSuffixEnum(String type, String name){
        this.type = type ;
        this.name = name;
    }


    public String getCode(){
        return this.type;
    }

    public String getName(){
        return this.name ;
    }


    public static List<String> getSuffixList(){
        SignFileSuffixEnum[] values = SignFileSuffixEnum.values();
        List<String> suffixList = new ArrayList<>();
        for(SignFileSuffixEnum suffixEnum : values){
            suffixList.add(suffixEnum.type);
        }
        return suffixList;
    }
}
