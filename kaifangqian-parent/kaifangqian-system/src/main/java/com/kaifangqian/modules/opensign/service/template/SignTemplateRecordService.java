/**
 * @description 模板操作记录接口类
 */
package com.kaifangqian.modules.opensign.service.template;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignTemplateRecord;

/**
 * @Description: SignTemplateRecordService
 * @Package: com.kaifangqian.modules.opensign.service.template
 * @ClassName: SignTemplateRecordService
 * @author: FengLai_Gong
 */
public interface SignTemplateRecordService extends IService<SignTemplateRecord> {


    SignTemplateRecord getCurrent(String templateId);


    Boolean setNotCurrent(String templateId);

}