/**
 * @description 签署业务功能类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 需要意愿校验的操作类型
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: ConfirmOperateType
 * @author: FengLai_Gong
 */
public enum ConfirmOperateType {

    SUBMIT_WRITE("submit_write","填写"),

    REJECT_WRITE("reject_write","拒填"),

    SUBMIT_SIGN("submit_sign","签署"),

    REJECT_SIGN("reject_sign","拒签"),

    REVOKE("revoke","撤销"),

    ;



    private String type;

    private String name;

    ConfirmOperateType(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public static ConfirmOperateType getByType(String type) {
        for (ConfirmOperateType confirmOperateType : ConfirmOperateType.values()) {
            if (confirmOperateType.getType().equals(type)) {
                return confirmOperateType;
            }
        }
        return null;
    }
}