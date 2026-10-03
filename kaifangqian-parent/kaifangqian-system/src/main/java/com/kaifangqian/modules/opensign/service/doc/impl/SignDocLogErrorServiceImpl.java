/**
 * @description 签署文档操作错误数据记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.doc.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignDocLogError;
import com.kaifangqian.modules.opensign.mapper.SignDocLogErrorMapper;
import com.kaifangqian.modules.opensign.service.doc.SignDocLogErrorService;
import org.springframework.stereotype.Service;

/**
 * @Description: SignDocLogErrorServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.doc.impl
 * @ClassName: SignDocLogErrorServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignDocLogErrorServiceImpl extends ServiceImpl<SignDocLogErrorMapper, SignDocLogError> implements SignDocLogErrorService {
}