/**
 * @description 文档详情数据对象
 */
package com.kaifangqian.modules.opensign.vo.base.sign;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaifangqian.modules.opensign.entity.SignRu;
import com.kaifangqian.modules.opensign.service.business.vo.YundunSignPositionArrayData;
import com.kaifangqian.modules.storage.entity.AnnexStorage;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: DocInfo
 * @Package: com.kaifangqian.modules.opensign.vo.base
 * @ClassName: DocInfo
 * @author: FengLai_Gong
 */
@Data
// @ApiModel("文档详情数据对象")
public class PdfSignVoInfo implements Serializable {

    private static final long serialVersionUID = -4829924328211608565L;

    /**
     * 合同ID
     */
    private String contractId;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 应用ID
     */
    private String appId;
    /**
     * 新文档文件字节映射
     */
    private Map<String, byte[]> newDocFileByteMap;
    /**
     * 企业印章字节数据
     */
    private byte[] entSealByte;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 证书持有者租户ID
     */
    private String certHolderTenantId;
    /**
     * 签署规则实体
     */
    private SignRu signRu;
    /**
     * 云盾签署位置数组数据列表
     */
    private List<YundunSignPositionArrayData> yundunSignPositionArrayDatas;
    /**
     * 签署类型
     */
    private String signType;
    /**
     * 个人签署认证类型
     */
    private String personalSignAuthType;
    /**
     * 签署任务ID
     */
    private String taskId;
}