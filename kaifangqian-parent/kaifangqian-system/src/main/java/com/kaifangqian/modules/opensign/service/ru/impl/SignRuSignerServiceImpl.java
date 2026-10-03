/**
 * @description 签署业务签署人相关接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignRuSigner;
import com.kaifangqian.modules.opensign.mapper.SignRuSignerMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuSignerService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Description: SignRuSignerServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuSignerServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuSignerServiceImpl extends ServiceImpl<SignRuSignerMapper, SignRuSigner> implements SignRuSignerService {


    @Override
    public List<SignRuSigner> listByRuId(String ruId) {
        QueryWrapper<SignRuSigner> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuSigner::getSignRuId, ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);
        wrapper.lambda().orderByAsc(SignRuSigner::getSignerOrder);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignRuSigner> getByEntity(SignRuSigner query) {
        LambdaQueryWrapper<SignRuSigner> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MyStringUtils.isNotBlank(query.getSignRuId()), SignRuSigner::getSignRuId, query.getSignRuId())
                .eq(query.getSignerType() != null, SignRuSigner::getSignerType, query.getSignerType())
                .eq(SignRuSigner::getDeleteFlag, false);

        queryWrapper.orderByAsc(SignRuSigner::getSignerOrder);

        return list(queryWrapper);
    }

    @Override
    public List<SignRuSigner> getByEntityForApi(SignRuSigner query) {
        LambdaQueryWrapper<SignRuSigner> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(MyStringUtils.isNotBlank(query.getSignRuId()), SignRuSigner::getSignRuId, query.getSignRuId())
                .eq(MyStringUtils.isNotBlank(query.getSignerName()), SignRuSigner::getSignerName, query.getSignerName())
                .eq(query.getSignerOrder() != null, SignRuSigner::getSignerOrder, query.getSignerOrder())
                .eq(query.getSignerType() != null, SignRuSigner::getSignerType, query.getSignerType())
                .eq(SignRuSigner::getDeleteFlag, false);

        queryWrapper.orderByAsc(SignRuSigner::getSignerOrder);
        return list(queryWrapper);
    }

    public void deleteByRuId(String ruId) {
        QueryWrapper<SignRuSigner> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuSigner::getSignRuId, ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);
        SignRuSigner signer = new SignRuSigner();
        signer.setDeleteFlag(true);
        this.baseMapper.update(signer, wrapper);
    }

    @Override
    public void deleteByIdList(List<String> idList) {
        QueryWrapper<SignRuSigner> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignRuSigner::getId, idList);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);
        SignRuSigner signer = new SignRuSigner();
        signer.setDeleteFlag(true);
        this.baseMapper.update(signer, wrapper);
    }

    @Override
    public List<SignRuSigner> listByRuIds(List<String> ruIds) {
        QueryWrapper<SignRuSigner> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignRuSigner::getSignRuId, ruIds);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);
        return this.baseMapper.selectList(wrapper);
    }
}