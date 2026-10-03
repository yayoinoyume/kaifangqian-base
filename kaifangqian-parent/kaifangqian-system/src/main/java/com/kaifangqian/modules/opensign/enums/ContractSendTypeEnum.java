/**
 * @description 文件签署发起类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

public enum ContractSendTypeEnum {

    API("api", "通过接口发起"),

    APP("app", "通过签署应用发起"),

    ;

    private String type;

    private String name;

    ContractSendTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public static ContractSendTypeEnum getByType(String type) {
        for (ContractSendTypeEnum confirmType : ContractSendTypeEnum.values()) {
            if (confirmType.getType().equals(type)) {
                return confirmType;
            }
        }
        return null;
    }

}