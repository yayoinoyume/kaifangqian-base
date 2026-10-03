/**
 * @description 模板申请数据记录接口类
 */
package com.kaifangqian.modules.opensign.service.template;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignTemplateLogApply;

import java.util.List;

/**
 * @Description: SignTemplateApplyLogService
 * @Package: com.kaifangqian.modules.opensign.service.template
 * @ClassName: SignTemplateApplyLogService
 * @author: FengLai_Gong
 */
public interface SignTemplateLogApplyService extends IService<SignTemplateLogApply> {


    SignTemplateLogApply findByTemplateId(String templateId);

    List<SignTemplateLogApply> findList(String templateId);
}