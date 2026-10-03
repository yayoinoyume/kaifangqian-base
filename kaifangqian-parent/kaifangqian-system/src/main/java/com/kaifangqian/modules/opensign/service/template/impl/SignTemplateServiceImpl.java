/**
 * @description 模板管理主数据接口实现类
 */
package com.kaifangqian.modules.opensign.service.template.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignTemplate;
import com.kaifangqian.modules.opensign.mapper.SignTemplateMapper;
import com.kaifangqian.modules.opensign.service.template.SignTemplateService;
import org.springframework.stereotype.Service;

/**
 * @Description: SignTemplateServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.template.impl
 * @ClassName: SignTemplateServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignTemplateServiceImpl extends ServiceImpl<SignTemplateMapper, SignTemplate> implements SignTemplateService {
}