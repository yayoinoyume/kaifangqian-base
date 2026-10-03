/**
 * @description 获取签署文档操作关联人接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignRuRelation;
import com.kaifangqian.modules.opensign.mapper.SignRuRelationMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuRelationService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignRuRelationServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuRelationServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuRelationServiceImpl extends ServiceImpl<SignRuRelationMapper, SignRuRelation> implements SignRuRelationService {

    @Override
    public List<SignRuRelation> getNoUserList(SignRuRelation query) {
        LambdaQueryWrapper<SignRuRelation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SignRuRelation::getExternalCcedType, query.getExternalCcedType())
                .eq(SignRuRelation::getExternalCcedValue, query.getExternalCcedValue())
                .eq(SignRuRelation::getDeleteFlag, false)
                .isNull(SignRuRelation::getTenantUserId);

        return list(queryWrapper);
    }

    @Override
    public List<SignRuRelation> getByEntity(SignRuRelation query) {
        LambdaQueryWrapper<SignRuRelation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MyStringUtils.isNotBlank(query.getSignRuId()), SignRuRelation::getSignRuId, query.getSignRuId())
                .eq(MyStringUtils.isNotBlank(query.getTenantUserId()), SignRuRelation::getTenantUserId, query.getTenantUserId())
                .eq(query.getRelationType() != null, SignRuRelation::getRelationType, query.getRelationType())
                .eq(MyStringUtils.isNotBlank(query.getExternalCcedValue()), SignRuRelation::getExternalCcedValue, query.getExternalCcedValue())
                .eq(SignRuRelation::getDeleteFlag, false);

        return list(queryWrapper);
    }
}