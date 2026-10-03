/**
 * @description 文档详情数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description: DocInfo
 * @Package: com.kaifangqian.modules.opensign.vo.base
 * @ClassName: DocInfo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("文档详情数据对象")
public class PdfSignResult implements Serializable {

    private static final long serialVersionUID = -4829924328211608565L;

    /**
     * 新文档文件字节映射
     */
    private Map<String, byte[]> newDocFileByteMap;
    /**
     * 最终签署类型
     */
    private Integer finalSignType;

    /**
     * 个人签署实名要求
     */
    private String personalSignAuth;

    /**
     * 签署认证类型
     */
    private Integer authType;

    /**
     * 签署订单号
     */
    private String signOrderNo;

}