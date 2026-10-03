/**
 * @description 业务线授权接口实现类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.common.system.vo.LoginUser;
import com.kaifangqian.common.util.MySecurityUtils;
import com.kaifangqian.modules.opensign.entity.SignReAuth;
import com.kaifangqian.modules.opensign.mapper.SignReAuthMapper;
import com.kaifangqian.modules.opensign.service.re.SignReAuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: SignReAuthServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReAuthServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReAuthServiceImpl extends ServiceImpl<SignReAuthMapper, SignReAuth> implements SignReAuthService {

    @Resource
    private SignReAuthMapper mapper;

    @Override
    public List<SignReAuth> listByReId(String reId) {
        QueryWrapper<SignReAuth> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReAuth::getSignReId, reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignReAuth> listByReIdList(List<String> reIdList, Integer authType) {
        QueryWrapper<SignReAuth> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SignReAuth::getSignReId, reIdList);
        wrapper.lambda().eq(SignReAuth::getAuthType, authType);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<SignReAuth> listByParam(String tenantUserId, List<Integer> authTypeList) {
        QueryWrapper<SignReAuth> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReAuth::getUserId, tenantUserId);
        wrapper.lambda().in(SignReAuth::getAuthType, authTypeList);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public Integer countByParam(String reId, String tenantId, String tenantUserId, List<Integer> authTypeList) {
        QueryWrapper<SignReAuth> wrapper = build(reId, tenantId, tenantUserId, authTypeList);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);
        return this.baseMapper.selectCount(wrapper).intValue();
    }

    @Override
    public List<SignReAuth> listByParam(String reId, String tenantId, String tenantUserId, List<Integer> authTypeList) {
        QueryWrapper<SignReAuth> wrapper = build(reId, tenantId, tenantUserId, authTypeList);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<String> getMyViewSignRe() {
        LoginUser loginUser = MySecurityUtils.getCurrentUser();
        return mapper.getMyViewSignRe(loginUser.getTenantUserId());
    }

    @Override
    public List<String> geSignReByTenantUserId(String tenantUserId) {
        return mapper.getMyViewSignRe(tenantUserId);
    }

    @Override
    public void deleteByReId(String reId) {
        QueryWrapper<SignReAuth> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReAuth::getSignReId, reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag, false);

        SignReAuth auth = new SignReAuth();
        auth.setDeleteFlag(true);

        this.baseMapper.update(auth, wrapper);
    }

    public QueryWrapper<SignReAuth> build(String reId, String tenantId, String tenantUserId, List<Integer> authTypeList) {
        QueryWrapper<SignReAuth> wrapper = new QueryWrapper<>();
        if (tenantUserId != null && tenantUserId.length() > 0) {
            wrapper.lambda().eq(SignReAuth::getUserId, tenantUserId);
        }
        if (authTypeList != null && authTypeList.size() > 0) {
            wrapper.lambda().in(SignReAuth::getAuthType, authTypeList);
        }
        if (reId != null && reId.length() > 0) {
            wrapper.lambda().eq(SignReAuth::getSignReId, reId);
        }
        if (tenantId != null && tenantId.length() > 0) {
            wrapper.lambda().eq(SignReAuth::getTenantId, tenantId);
        }

        return wrapper;
    }

}