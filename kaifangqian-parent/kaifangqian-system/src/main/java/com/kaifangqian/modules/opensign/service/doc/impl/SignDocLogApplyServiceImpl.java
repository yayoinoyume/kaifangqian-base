/**
 * @description 签署文档审批日志接口实现类
 */
package com.kaifangqian.modules.opensign.service.doc.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignDocLogApply;
import com.kaifangqian.modules.opensign.mapper.SignDocLogApplyMapper;
import com.kaifangqian.modules.opensign.service.doc.SignDocLogApplyService;
import org.springframework.stereotype.Service;

/**
 * @Description: SignDocApplyLogServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.doc.impl
 * @ClassName: SignDocApplyLogServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignDocLogApplyServiceImpl extends ServiceImpl<SignDocLogApplyMapper, SignDocLogApply> implements SignDocLogApplyService {
}