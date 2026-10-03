/**
 * @description 业务线文档参数接口实现类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignReDocParam;
import com.kaifangqian.modules.opensign.mapper.SignReDocParamMapper;
import com.kaifangqian.modules.opensign.service.re.SignReDocParamService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReDocParamServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReDocParamServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReDocParamServiceImpl extends ServiceImpl<SignReDocParamMapper, SignReDocParam> implements SignReDocParamService {

    @Override
    public List<SignReDocParam> listByReDocId(String reDocId) {
        QueryWrapper<SignReDocParam> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocParam::getSignReDocId,reDocId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignReDocParam> listByReId(String reId) {
        QueryWrapper<SignReDocParam> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocParam::getSignReId,reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignReDocParam> listByReSignerId(String signerId) {
        QueryWrapper<SignReDocParam> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocParam::getSignerId,signerId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public void deleteByRe(String reId) {
        QueryWrapper<SignReDocParam> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocParam::getSignReId,reId);

        this.baseMapper.delete(wrapper);
    }

    @Override
    public void deleteByParam(List<String> reDocIdList, String reId) {
        QueryWrapper<SignReDocParam> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReDocParam::getSignReId,reId);
        wrapper.lambda().in(SignReDocParam::getSignReDocId,reDocIdList);


        this.baseMapper.delete(wrapper);
    }
}