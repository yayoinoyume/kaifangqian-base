/**
 * @description 电子印章-企业印章管理操作错误记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.seal.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignEntSealLogError;
import com.kaifangqian.modules.opensign.mapper.SignEntSealLogErrorMapper;
import com.kaifangqian.modules.opensign.service.seal.SignEntSealLogErrorService;
import org.springframework.stereotype.Service;

/**
 * @Description: SignEntSealLogErrorServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.seal.impl
 * @ClassName: SignEntSealLogErrorServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignEntSealLogErrorServiceImpl extends ServiceImpl<SignEntSealLogErrorMapper, SignEntSealLogError> implements SignEntSealLogErrorService {
}