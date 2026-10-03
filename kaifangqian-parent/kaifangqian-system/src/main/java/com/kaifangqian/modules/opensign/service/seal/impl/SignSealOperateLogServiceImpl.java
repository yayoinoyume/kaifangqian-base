/**
 * @description 电子印章-印章管理操作记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.seal.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignSealOperateLog;
import com.kaifangqian.modules.opensign.mapper.SignSealOperateLogMapper;
import com.kaifangqian.modules.opensign.service.seal.SignSealOperateLogService;
import org.springframework.stereotype.Service;

/**
 * @Description: SignSealOperateLogServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.seal.impl
 * @ClassName: SignSealOperateLogServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignSealOperateLogServiceImpl extends ServiceImpl<SignSealOperateLogMapper, SignSealOperateLog> implements SignSealOperateLogService {
}