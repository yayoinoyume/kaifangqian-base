package com.kaifangqian.modules.opensign.vo.response.ru;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: RunSignConfirmResponse
 * @Package: com.kaifangqian.modules.opensign.vo.response.ru
 * @ClassName: RunSignConfirmResponse
 * @author: FengLai_Gong
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
// 签署节点配置信息
// Signature node configuration information
public class SignNodeConfigResponse implements Serializable {

    // 个人实名认证配置
    // Personal real-name authentication configuration
    private String personalSignAuth ;

    // 个人签署图片类型
    private String sealType;


}