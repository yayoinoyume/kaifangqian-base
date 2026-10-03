/**
 * @description 签署文档操作管理接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignRuDocOperate;
import com.kaifangqian.modules.opensign.enums.SignCurrentEnum;
import com.kaifangqian.modules.opensign.mapper.SignRuDocOperateMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuDocOperateService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignRuDocOperateServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuDocOperateServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuDocOperateServiceImpl extends ServiceImpl<SignRuDocOperateMapper, SignRuDocOperate> implements SignRuDocOperateService {


    @Override
    public List<SignRuDocOperate> listByRuId(String ruId) {
        QueryWrapper<SignRuDocOperate> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuDocOperate::getSignRuId,ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignRuDocOperate> listByRuIdCurrent(String ruId) {
        QueryWrapper<SignRuDocOperate> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuDocOperate::getSignRuId,ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignRuDocOperate::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignRuDocOperate> listByParam(String ruId, String docId) {
        QueryWrapper<SignRuDocOperate> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuDocOperate::getSignRuId,ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignRuDocOperate::getDocId,docId);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignRuDocOperate> listByParamCurrent(String ruId, String docId) {
        QueryWrapper<SignRuDocOperate> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuDocOperate::getSignRuId,ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignRuDocOperate::getDocId,docId);
        wrapper.lambda().eq(SignRuDocOperate::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignRuDocOperate> listByParamCurrent(String ruId, List<String> docIdList) {
        QueryWrapper<SignRuDocOperate> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuDocOperate::getSignRuId,ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().in(SignRuDocOperate::getDocId,docIdList);
        wrapper.lambda().eq(SignRuDocOperate::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public SignRuDocOperate getCurrentByDocId(String docId) {
        QueryWrapper<SignRuDocOperate> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignRuDocOperate::getDocId,docId);
        wrapper.lambda().eq(SignRuDocOperate::getIsCurrent, SignCurrentEnum.IS_CURRENT.getCode());

        List<SignRuDocOperate> signRuDocOperates = this.baseMapper.selectList(wrapper);
        if(signRuDocOperates != null && signRuDocOperates.size() > 0){
            return signRuDocOperates.get(0);
        }
        return null ;
    }

    @Override
    public void deleteByParam(List<String> docIdList ,String ruId) {
        QueryWrapper<SignRuDocOperate> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignRuDocOperate::getDocId,docIdList);
        wrapper.lambda().eq(SignRuDocOperate::getSignRuId,ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignRuDocOperate ruDocOperate = new SignRuDocOperate();
        ruDocOperate.setDeleteFlag(true);

        this.baseMapper.update(ruDocOperate,wrapper);
    }
}