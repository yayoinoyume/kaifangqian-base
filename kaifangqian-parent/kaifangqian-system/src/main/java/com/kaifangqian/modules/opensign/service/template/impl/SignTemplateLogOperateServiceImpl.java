/**
 * @description 模板操作记录接口类
 */
package com.kaifangqian.modules.opensign.service.template.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignTemplateLogOperate;
import com.kaifangqian.modules.opensign.mapper.SignTemplateLogOperateMapper;
import com.kaifangqian.modules.opensign.service.template.SignTemplateLogOperateService;
import org.springframework.stereotype.Service;
/**
 * @Description: SignTemplateOperateLogServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.template.impl
 * @ClassName: SignTemplateOperateLogServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignTemplateLogOperateServiceImpl extends ServiceImpl<SignTemplateLogOperateMapper, SignTemplateLogOperate> implements SignTemplateLogOperateService {
}