/**
 * @description 签署抄送人服务接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignRuCcer;
import com.kaifangqian.modules.opensign.mapper.SignRuCcerMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuCcerService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignRuCcerServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuCcerServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuCcerServiceImpl extends ServiceImpl<SignRuCcerMapper, SignRuCcer> implements SignRuCcerService {

    @Override
    public List<SignRuCcer> listByRuId(String ruId) {
        QueryWrapper<SignRuCcer> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuCcer::getSignRuId, ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignRuCcer> getByEntity(SignRuCcer query) {
        LambdaQueryWrapper<SignRuCcer> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MyStringUtils.isNotBlank(query.getSignRuId()), SignRuCcer::getSignRuId, query.getSignRuId())
                .eq(MyStringUtils.isNotBlank(query.getTenantUserId()), SignRuCcer::getTenantUserId, query.getTenantUserId())
                .eq(SignRuCcer::getDeleteFlag, false);

        return list(queryWrapper);
    }

    public void deleteByRuId(String ruId) {
        QueryWrapper<SignRuCcer> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuCcer::getSignRuId, ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);
        SignRuCcer ccer = new SignRuCcer();
        ccer.setDeleteFlag(true);
        this.baseMapper.update(ccer, wrapper);
    }
}