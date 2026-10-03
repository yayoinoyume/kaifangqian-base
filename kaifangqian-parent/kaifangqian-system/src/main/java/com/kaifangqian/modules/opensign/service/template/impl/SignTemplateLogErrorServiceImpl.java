/**
 * @description 模板操作错误数据记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.template.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignTemplateLogError;
import com.kaifangqian.modules.opensign.mapper.SignTemplateLogErrorMapper;
import com.kaifangqian.modules.opensign.service.template.SignTemplateLogErrorService;
import org.springframework.stereotype.Service;

/**
 * @Description: SignTemplateLogErrorServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.template.impl
 * @ClassName: SignTemplateLogErrorServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignTemplateLogErrorServiceImpl extends ServiceImpl<SignTemplateLogErrorMapper, SignTemplateLogError> implements SignTemplateLogErrorService {
}