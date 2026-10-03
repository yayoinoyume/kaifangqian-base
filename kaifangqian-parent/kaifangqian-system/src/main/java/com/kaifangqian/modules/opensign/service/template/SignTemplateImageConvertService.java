/**
 * @description 模板图片转换数据记录接口类
 */
package com.kaifangqian.modules.opensign.service.template;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.opensign.entity.SignTemplateImageConvert;

import java.util.List;

/**
 * @Description: SignTemplateImageConvertService
 * @Package: com.kaifangqian.modules.opensign.service.template
 * @ClassName: SignTemplateImageConvertService
 * @author: FengLai_Gong
 */
public interface SignTemplateImageConvertService extends IService<SignTemplateImageConvert> {

    Integer count(String templateId ,String annexId);

    List<SignTemplateImageConvert> getList(String templateId , String annexId);


    void delete(String templateId ,String annexId);



}