/**
 * @description 签署业务校验服务接口类
 */
package com.kaifangqian.modules.opensign.service.ru;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignRuSignConfirm;

import java.util.List;

/**
 * @Description: SignRuSignConfirmService
 * @Package: com.kaifangqian.modules.opensign.service.ru
 * @ClassName: SignRuSignConfirmService
 * @author: FengLai_Gong
 */
public interface SignRuSignConfirmService extends IService<SignRuSignConfirm> {

    void save(String signerId,String ruId,Integer signerType , Integer isFastSign, String verifyType, String personalSignAuth, String sealType);

    SignRuSignConfirm getByParam(String signerId, String ruId);

    List<SignRuSignConfirm> listByParam(String ruId);

    void delete(String signerId,String ruId);



}