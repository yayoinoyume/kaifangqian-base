/**
 * @description 文件格式类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 文件类型枚举
 * @Package: com.kaifangqian.modules.opensign.service.cert
 * @ClassName: FileEnum
 * @author: Fusion
 * CreateTime:  2023/8/19  14:50
 * @copyright 本平台运营方
 */

public enum FileEnum {

    DOCX(".docx"),

    DOC(".DOC"),

    PDF(".pdf"),

    PNG(".png"),

    PFX(".pfx"),

    OFD(".ofd"),
    ;
    private String prefix;

    FileEnum(String preFix){
        this.prefix = preFix;
    }

    public String getPrefix() { return prefix; }

    public void setPrefix(String prefix) { this.prefix = prefix; }
}
