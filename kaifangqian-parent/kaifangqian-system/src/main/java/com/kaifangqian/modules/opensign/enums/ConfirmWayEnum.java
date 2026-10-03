/**
 * @description 验证方式枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: ConfirmWayEnum
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: ConfirmWayEnum
 * @author: FengLai_Gong
 */
public enum ConfirmWayEnum {


    NONE("NONE","无校验方式"),
    SINGLE("single","单一校验方式"),
    MULTIPLE("multiple","多重校验方式"),

    ;

    private String type;

    private String name;

    ConfirmWayEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public static ConfirmWayEnum getByType(String type) {
        for (ConfirmWayEnum confirmWay : ConfirmWayEnum.values()) {
            if (confirmWay.getType().equals(type)) {
                return confirmWay;
            }
        }
        return null;
    }
}