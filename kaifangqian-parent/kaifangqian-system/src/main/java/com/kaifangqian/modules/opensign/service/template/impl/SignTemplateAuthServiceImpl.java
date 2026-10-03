/**
 * @description 模板授权数据接口实现类
 */
package com.kaifangqian.modules.opensign.service.template.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignTemplateAuth;
import com.kaifangqian.modules.opensign.mapper.SignTemplateAuthMapper;
import com.kaifangqian.modules.opensign.service.template.SignTemplateAuthService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignTemplateAuthServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.template.impl
 * @ClassName: SignTemplateAuthServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignTemplateAuthServiceImpl extends ServiceImpl<SignTemplateAuthMapper, SignTemplateAuth> implements SignTemplateAuthService {


    @Override
    public void deleteByTemplateId(String templateId) {
        QueryWrapper<SignTemplateAuth> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignTemplateAuth::getTemplateId,templateId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignTemplateAuth auth = new SignTemplateAuth();
        auth.setDeleteFlag(true);

        this.baseMapper.update(auth,wrapper);
    }

    @Override
    public List<SignTemplateAuth> listByTemplateId(String templateId) {
        QueryWrapper<SignTemplateAuth> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignTemplateAuth::getTemplateId,templateId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignTemplateAuth> listByParam(String tenantId, String tenantUseId, List<Integer> authTypeList) {
        QueryWrapper<SignTemplateAuth> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignTemplateAuth::getTenantUserId,tenantUseId);
        wrapper.lambda().eq(SignTemplateAuth::getTenantId,tenantId);
        wrapper.lambda().in(SignTemplateAuth::getAuthType,authTypeList);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }
}