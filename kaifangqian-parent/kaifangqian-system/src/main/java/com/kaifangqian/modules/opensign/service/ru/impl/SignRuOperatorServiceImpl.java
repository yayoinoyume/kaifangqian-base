/**
 * @description 获取签署文档操作人接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignRuOperator;
import com.kaifangqian.modules.opensign.mapper.SignRuOperatorMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuOperatorService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignRuOperatorServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuOperatorServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuOperatorServiceImpl extends ServiceImpl<SignRuOperatorMapper, SignRuOperator> implements SignRuOperatorService {
    @Override
    public List<SignRuOperator> listByRuId(String ruId) {
        QueryWrapper<SignRuOperator> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuOperator::getSignRuId, ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignRuOperator> getByEntity(SignRuOperator query) {
        LambdaQueryWrapper<SignRuOperator> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MyStringUtils.isNotBlank(query.getSignRuId()), SignRuOperator::getSignRuId, query.getSignRuId())
                .eq(query.getOperateType() != null, SignRuOperator::getOperateType, query.getOperateType())
                .eq(query.getSignerType() != null, SignRuOperator::getSignerType, query.getSignerType())
                .eq(query.getOperateStatus() != null, SignRuOperator::getOperateStatus, query.getOperateStatus())
                .eq(MyStringUtils.isNotBlank(query.getSignerId()), SignRuOperator::getSignerId, query.getSignerId())
                .in(CollUtil.isNotEmpty(query.getSignerTypes()), SignRuOperator::getSignerType, query.getSignerTypes())
                .eq(SignRuOperator::getDeleteFlag, false);

        queryWrapper.orderByAsc(SignRuOperator::getOperateOrder);

        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public void deleteByRuId(String ruId) {
        QueryWrapper<SignRuOperator> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuOperator::getSignRuId, ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);

        this.baseMapper.delete(wrapper);
    }
}