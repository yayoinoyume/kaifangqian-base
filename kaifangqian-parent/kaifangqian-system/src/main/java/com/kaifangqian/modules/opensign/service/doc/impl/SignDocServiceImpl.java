/**
 * @description 签署文档数据记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.doc.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.service.doc.SignDocService;
import com.kaifangqian.modules.opensign.entity.SignDoc;
import com.kaifangqian.modules.opensign.mapper.SignDocMapper;
import org.springframework.stereotype.Service;

/**
 * @Description: SignDocServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.doc.impl
 * @ClassName: SignDocServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignDocServiceImpl extends ServiceImpl<SignDocMapper, SignDoc> implements SignDocService {
}