/**
 * @description 模板授权数据接口类
 */
package com.kaifangqian.modules.opensign.service.template;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignTemplateAuth;

import java.util.List;

/**
 * @Description: SignTemplateAuthService
 * @Package: com.kaifangqian.modules.opensign.service.template
 * @ClassName: SignTemplateAuthService
 * @author: FengLai_Gong
 */
public interface SignTemplateAuthService extends IService<SignTemplateAuth> {

    void deleteByTemplateId(String templateId);

    List<SignTemplateAuth> listByTemplateId(String templateId);

    List<SignTemplateAuth> listByParam(String tenantId,String tenantUseId,List<Integer> authTypeList);
}