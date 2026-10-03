/**
 * @description 模板管理接口类
 */
package com.kaifangqian.modules.opensign.service.template;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignTemplateControl;

import java.util.List;

/**
 * @Description: SignTemplateControlService
 * @Package: com.kaifangqian.modules.opensign.service.template
 * @ClassName: SignTemplateControlService
 * @author: FengLai_Gong
 */
public interface SignTemplateControlService extends IService<SignTemplateControl> {

    Integer count(String templateId);

    Integer count(List<String> templateIdList);

    List<SignTemplateControl> getList(String templateId);

    List<SignTemplateControl> getList(List<String> templateIdList);

    void delete(String templateId);


}