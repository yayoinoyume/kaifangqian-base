/**
 * @description 企业管理功能枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: EntSealOperateTypeEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: EntSealOperateTypeEnum
 * @author: FengLai_Gong
 */
public enum EntSealOperateTypeEnum {


    MAKE(1,"制作"),
    EDIT(2,"编辑"),
    CHANGE(3,"章面变更"),
    ENABLED(4,"启用"),
    UN_ENABLED(5,"停用"),
    DIVESTED(6,"收缴"),
    DESTRUCTION(7,"销毁"),

    LIST(8,"查看列表"),
    INFO(9,"查看详情"),


    ;
    EntSealOperateTypeEnum(Integer code ,String name){
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