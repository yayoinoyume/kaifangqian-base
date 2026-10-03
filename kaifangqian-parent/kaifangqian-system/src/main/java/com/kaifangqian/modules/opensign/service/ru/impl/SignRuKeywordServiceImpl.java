/**
 * @description 签署文档关键字接口类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignRuKeyword;
import com.kaifangqian.modules.opensign.mapper.SignRuKeywordMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuKeywordService;
import org.springframework.stereotype.Service;

/**
 * @Description: SignRuKeywordServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuKeywordServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuKeywordServiceImpl extends ServiceImpl<SignRuKeywordMapper, SignRuKeyword> implements SignRuKeywordService {
}