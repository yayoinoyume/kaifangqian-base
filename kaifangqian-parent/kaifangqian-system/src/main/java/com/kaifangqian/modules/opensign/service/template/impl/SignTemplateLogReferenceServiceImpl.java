/**
 * @description 模板引用数据记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.template.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignTemplateLogReference;
import com.kaifangqian.modules.opensign.mapper.SignTemplateLogReferenceMapper;
import com.kaifangqian.modules.opensign.service.template.SignTemplateLogReferenceService;
import org.springframework.stereotype.Service;
/**
 * @Description: SignTemplateReferenceLogServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.template.impl
 * @ClassName: SignTemplateReferenceLogServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignTemplateLogReferenceServiceImpl extends ServiceImpl<SignTemplateLogReferenceMapper, SignTemplateLogReference> implements SignTemplateLogReferenceService {
}