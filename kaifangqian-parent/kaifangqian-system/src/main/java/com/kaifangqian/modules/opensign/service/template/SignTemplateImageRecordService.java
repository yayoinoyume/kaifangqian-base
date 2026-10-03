/**
 * @description 模板图片转换数据记录接口类
 */
package com.kaifangqian.modules.opensign.service.template;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignTemplateImageRecord;

import java.util.List;

/**
 * @Description: SignTemplateImageRecordService
 * @Package: com.kaifangqian.modules.opensign.service.template
 * @ClassName: SignTemplateImageRecordService
 * @author: FengLai_Gong
 */
public interface SignTemplateImageRecordService extends IService<SignTemplateImageRecord> {

    List<SignTemplateImageRecord> getCurrentList(String templateId);

    Integer countCurrentList(String templateId);

    void updateNotCurrent(String templateId);


}