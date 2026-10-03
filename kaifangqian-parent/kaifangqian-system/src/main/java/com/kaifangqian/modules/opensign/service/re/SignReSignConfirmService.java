/**
 * @description 业务线管理接口
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReSignConfirm;

import java.util.List;

/**
 * @Description: SignReSignConfirmService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReSignConfirmService
 * @author: FengLai_Gong
 */
public interface SignReSignConfirmService extends IService<SignReSignConfirm> {

    void save(String signerId,String reId,Integer signerType,Integer isFastSign, String verifyType, String personalSignAuth, String sealType);

    SignReSignConfirm getByParam(String signerId,String reId);

    List<SignReSignConfirm> listByParam(String reId);

    void delete(String signerId,String reId);


}