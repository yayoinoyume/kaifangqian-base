/**
 * @description 签署文档关键字接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignRuKeywordProperty;
import com.kaifangqian.modules.opensign.mapper.SignRuKeywordPropertyMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuKeywordPropertyService;
import org.springframework.stereotype.Service;

/**
 * @Description: SignRuKeywordPropertyServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuKeywordPropertyServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuKeywordPropertyServiceImpl extends ServiceImpl<SignRuKeywordPropertyMapper, SignRuKeywordProperty> implements SignRuKeywordPropertyService {
}