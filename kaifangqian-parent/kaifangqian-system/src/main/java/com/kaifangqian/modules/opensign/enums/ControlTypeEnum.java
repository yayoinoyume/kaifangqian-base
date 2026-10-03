/**
 * @description 控件类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 控件类型枚举
 * @Package: com.kaifangqian.modules.sign.enums
 * @ClassName: ControlTypeEnum
 * @author: FengLai_Gong
 */
public enum ControlTypeEnum {

    //个人签章
    SIGNATURE(1,"signature","SIGNATURE"),
    //企业签章
    SEAL(2,"seal","SEAL"),
    //签署日期
    SIGN_DATE(6,"sign-date","SIGN_DATE"),
    //骑缝签
    CHOP_STAMP(8,"chop-stamp","CHOP_STAMP"),

    //单行文本
    LINE_TEXT(3,"line-text"),
    //多行文本
    MULTILINE_TEXT(4,"multiline-text"),
    //时间
    DATE(5,"date"),
    //数字
    NUMBER(7,"number"),

    //图片
    IMAGE(9,"image"),
    //下拉列表
    DROPDOWN_LIST(10,"dropdown-list"),
    //单选
    RADIO(11,"radio"),
    //复选
    CHECKBOX(12,"check-box"),




    ;

    private Integer code  ;

    private String name ;

    private String apiName ;

    ControlTypeEnum(Integer code, String name){
        this.code = code ;
        this.name = name;
    }

    ControlTypeEnum(Integer code, String name,String apiName){
        this.code = code ;
        this.name = name;
        this.apiName = apiName;
    }


    public Integer getCode(){
        return this.code;
    }

    public String getName(){
        return this.name ;
    }

    public String getApiName(){
        return this.apiName;
    }

    public static List<String> getApiControlTypeList(){
        List<String> list = new ArrayList<>();
        list.add(ControlTypeEnum.SIGNATURE.getApiName());
        list.add(ControlTypeEnum.SEAL.getApiName());
        list.add(ControlTypeEnum.SIGN_DATE.getApiName());
        list.add(ControlTypeEnum.CHOP_STAMP.getApiName());
        return list ;
    }

    /**
     * @Description #获取所有填写类型
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    public static List<String> getWriteList(){
        List<String> list = new ArrayList<>();
        list.add(ControlTypeEnum.DATE.getName());
        list.add(ControlTypeEnum.LINE_TEXT.getName());
        list.add(ControlTypeEnum.MULTILINE_TEXT.getName());
        list.add(ControlTypeEnum.NUMBER.getName());
        list.add(ControlTypeEnum.IMAGE.getName());
        list.add(ControlTypeEnum.DROPDOWN_LIST.getName());
        list.add(ControlTypeEnum.RADIO.getName());
        list.add(ControlTypeEnum.CHECKBOX.getName());
        return list ;
    }

    /**
     * @Description #获取所有签署类型
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    public static List<String> getSignList(){
        List<String> list = new ArrayList<>();
        list.add(ControlTypeEnum.SIGNATURE.getName());
        list.add(ControlTypeEnum.SEAL.getName());
        list.add(ControlTypeEnum.SIGN_DATE.getName());
        list.add(ControlTypeEnum.CHOP_STAMP.getName());
        return list ;
    }
}