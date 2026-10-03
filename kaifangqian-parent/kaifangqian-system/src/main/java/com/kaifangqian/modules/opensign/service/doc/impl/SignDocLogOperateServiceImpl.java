/**
 * @description 签署文档操作错误数据记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.doc.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignDocLogOperate;
import com.kaifangqian.modules.opensign.mapper.SignDocLogOperateMapper;
import com.kaifangqian.modules.opensign.service.doc.SignDocLogOperateService;
import org.springframework.stereotype.Service;

/**
 * @Description: SignDocOperateLogServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.doc.impl
 * @ClassName: SignDocOperateLogServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignDocLogOperateServiceImpl extends ServiceImpl<SignDocLogOperateMapper, SignDocLogOperate> implements SignDocLogOperateService {
}