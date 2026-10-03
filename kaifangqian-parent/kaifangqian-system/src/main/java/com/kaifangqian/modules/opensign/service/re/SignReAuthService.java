/**
 * @description 业务线授权接口类
 */
package com.kaifangqian.modules.opensign.service.re;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignReAuth;

import java.util.List;

/**
 * @Description: SignReAuthService
 * @Package: com.kaifangqian.modules.opensign.service.re
 * @ClassName: SignReAuthService
 * @author: FengLai_Gong
 */
public interface SignReAuthService extends IService<SignReAuth> {


    List<SignReAuth> listByReId(String reId);

    List<SignReAuth> listByReIdList(List<String> reIdList,Integer authType);

    List<SignReAuth> listByParam(String tenantUserId,List<Integer> authTypeList);

    Integer countByParam(String reId ,String tenantId ,String tenantUserId ,List<Integer> authTypeList);

    List<SignReAuth> listByParam(String reId ,String tenantId ,String tenantUserId ,List<Integer> authTypeList);

    List<String> getMyViewSignRe();

    List<String> geSignReByTenantUserId(String tenantUserId);

    void deleteByReId(String reId);
}