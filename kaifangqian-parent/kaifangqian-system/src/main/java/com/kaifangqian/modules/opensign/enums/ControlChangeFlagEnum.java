/**
 * @description 签署控制枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: ControlChangeFlagEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: ControlChangeFlagEnum
 * @author: FengLai_Gong
 */
public enum ControlChangeFlagEnum {



    NECESSARY_AND_ADD("necessary_and_add","必须签署，可增加新的签署位置,默认值"),
    NECESSARY_NO_ADD("necessary_no_add","必须签署，不可增加新的签署位置"),
    NOT_NECESSARY("not_necessary","非必须签署"),

    ;

    private String type;

    private String name;

    ControlChangeFlagEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public static ControlChangeFlagEnum getByType(String type) {
        for (ControlChangeFlagEnum flag : ControlChangeFlagEnum.values()) {
            if (flag.getType().equals(type)) {
                return flag;
            }
        }
        return null;
    }
}