/**
 * @description 获取签署文档操作发送人接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignRuSender;
import com.kaifangqian.modules.opensign.mapper.SignRuSenderMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuSenderService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignRuSenderServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuSenderServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuSenderServiceImpl extends ServiceImpl<SignRuSenderMapper, SignRuSender> implements SignRuSenderService {
    @Override
    public List<SignRuSender> listBySignerId(String signerId) {
        QueryWrapper<SignRuSender> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuSender::getSignerId, signerId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignRuSender> getByEntity(SignRuSender query) {
        LambdaQueryWrapper<SignRuSender> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MyStringUtils.isNotBlank(query.getSignerId()), SignRuSender::getSignerId, query.getSignerId())
                .eq(SignRuSender::getDeleteFlag, false);

        queryWrapper.orderByAsc(SignRuSender::getSenderOrder);

        return list(queryWrapper);
    }
}