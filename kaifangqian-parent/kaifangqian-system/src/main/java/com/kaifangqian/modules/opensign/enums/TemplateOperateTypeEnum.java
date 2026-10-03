/**
 * @description 模板操作类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: EntSealOperateTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: EntSealOperateTypeEnum
 * @author: FengLai_Gong
 */
public enum TemplateOperateTypeEnum {


    MAKE(1,"模版制作保存"),
    CHANGE(2,"模版变更保存"),
    EDIT(3,"模版编辑"),
    ENABLED(4,"模板启用"),
    UN_ENABLED(5,"模板停用"),

    REMOVE(6,"模板移动"),
    PARAM_DOWNLOAD(7,"模板参数下载"),


    ;

    public static String getName(Integer code) {
        TemplateOperateTypeEnum[] values = TemplateOperateTypeEnum.values();
        for(TemplateOperateTypeEnum templateOperateTypeEnum : values){
            if(templateOperateTypeEnum.getCode().equals(code)){
                return templateOperateTypeEnum.getName();
            }
        }
        return null ;
    }

    TemplateOperateTypeEnum(Integer code , String name){
        this.code = code;
        this.name = name;
    }

    private Integer code ;
    private String name ;

    public String getName(){
        return this.name;
    }

    public Integer getCode(){
        return this.code;
    }




}