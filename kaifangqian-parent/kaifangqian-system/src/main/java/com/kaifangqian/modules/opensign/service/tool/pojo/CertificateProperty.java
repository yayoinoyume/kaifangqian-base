/**
 * @description 证书文件属性类
 */
package com.kaifangqian.modules.opensign.service.tool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 证书文件属性类
 * @Package: com.kaifangqian.modules.sign.pojo
 * @ClassName: CertificateProperty
 * @author: FengLai_Gong
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CertificateProperty implements Serializable {

    private static final long serialVersionUID = -2073805779543816269L;

    private  byte[] certFile;
    /** 证书的类型 比如：PKCS12和jks*/
    private  String certType;
    /** 证书密码 */
    private  String password;
    //租户证书关联表id
    private String tenantCertificateId ;
    //租户证书类型
    private Integer tenantCertificateType ;
    //证书表id
    private String certificateInfoId ;
    //证书归属租户id
    private String tenantId ;


}