/**
 * @description 业务线配置-单号生成规则类型
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 业务线配置-单号生成规则类型
 * @Package: com.kaifangqian.modules.opensign.enums
 * @ClassName: SignReRuleTypeEnum
 * @author: FengLai_Gong
 */
public enum SignReRuleDetailContentTypeEnum {

    DATETIME("datetime", "日期"),
    SERIAL_NUM("serialnum", "序列号"),
    TEXT("text", "文本"),
    TIMESTAMP("timestamp", "时间戳"),
    BUSINESS_LINE_NAME("business_line_name", "业务线名称"),
    SENDER_NAME("sender_name", "发起人姓名"),
    RECEIVER_NAME("receiver_name", "接收方名称"),


    ;

    private String code  ;

    private String name ;

    SignReRuleDetailContentTypeEnum(String code, String name){
        this.code = code ;
        this.name = name;
    }


    public String getCode(){
        return this.code;
    }

    public String getName(){
        return this.name ;
    }


}