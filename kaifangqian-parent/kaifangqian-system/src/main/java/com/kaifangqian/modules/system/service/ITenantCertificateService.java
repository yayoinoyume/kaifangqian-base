package com.kaifangqian.modules.system.service;

import com.kaifangqian.modules.cert.enums.CertTypeEnum;
import com.kaifangqian.modules.system.entity.TenantCertificate;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 租户证书关联表 服务类
 * </p>
 *
 * @author Administrator
 * @since 2023-10-10
 */
public interface ITenantCertificateService extends IService<TenantCertificate> {


    /**
     * @Description #根据证书类型获取证书列表
     * @Param [tenantId, certTypeEnum]
     * @return java.util.List<com.kaifangqian.modules.system.entity.TenantCertificate>
     **/
    List<TenantCertificate> getCertList(String tenantId, CertTypeEnum certTypeEnum);

    /**
     * @Description #根据证书类型和租户id，统计有效证书数量
     * @Param [tenantId, certTypeEnum]
     * @return java.lang.Integer
     **/
    Integer countEnabledCert(String tenantId, CertTypeEnum certTypeEnum);

    /**
     * @Description #根据证书类型和租户id，统计所有证书数量
     * @Param [tenantId, certTypeEnum]
     * @return java.lang.Integer
     **/
    Integer countCert(String tenantId, CertTypeEnum certTypeEnum);

    /**
     * @Description #根据证书类型和租户id，获取有效证书
     * @Param [tenantId, certTypeEnum]
     * @return com.kaifangqian.modules.system.entity.TenantCertificate
     **/
    TenantCertificate getEnabledCert(String tenantId, CertTypeEnum certTypeEnum);

    List<TenantCertificate> getEnabledCertList(String tenantId, CertTypeEnum certTypeEnum);

    /**
     * @Description #
     * @Param [tenantId, certTypeEnum]
     * @return void
     **/
    void unable(String tenantId,  Integer certType);

}
