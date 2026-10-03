/**
 * @description 签署业务校验服务接口实现类
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignRuSignConfirm;
import com.kaifangqian.modules.opensign.mapper.SignRuSignConfirmMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuSignConfirmService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignRuSignConfirmServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuSignConfirmServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuSignConfirmServiceImpl extends ServiceImpl<SignRuSignConfirmMapper, SignRuSignConfirm> implements SignRuSignConfirmService {


    @Override
    public void save(String signerId, String ruId, Integer signerType,Integer isFastSign, String verifyType, String personalSignAuth, String sealType) {
        SignRuSignConfirm signRuSignConfirm = new SignRuSignConfirm();
        signRuSignConfirm.setSignRuId(ruId);
        signRuSignConfirm.setSignerId(signerId);
        signRuSignConfirm.setSignerType(signerType);
        signRuSignConfirm.setConfirmType(verifyType);
        signRuSignConfirm.setAgreeSkipWillingness(isFastSign);
        signRuSignConfirm.setPersonalSignAuth(personalSignAuth);
        signRuSignConfirm.setSealType(sealType);
        save(signRuSignConfirm);
    }

    @Override
    public SignRuSignConfirm getByParam(String signerId, String ruId) {
        QueryWrapper<SignRuSignConfirm> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuSignConfirm::getSignRuId,ruId);
        wrapper.lambda().eq(SignRuSignConfirm::getSignerId,signerId);
        List<SignRuSignConfirm> signConfirmList = this.baseMapper.selectList(wrapper);
        if(signConfirmList != null && signConfirmList.size() > 0){
            return signConfirmList.get(0);
        }
        return null;
    }

    @Override
    public List<SignRuSignConfirm> listByParam(String ruId) {
        QueryWrapper<SignRuSignConfirm> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuSignConfirm::getSignRuId,ruId);
        List<SignRuSignConfirm> signConfirmList = this.baseMapper.selectList(wrapper);
        return signConfirmList;
    }

    @Override
    public void delete(String signerId, String ruId) {
        QueryWrapper<SignRuSignConfirm> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuSignConfirm::getSignRuId,ruId);
        wrapper.lambda().eq(SignRuSignConfirm::getSignerId,signerId);
        this.baseMapper.delete(wrapper);
    }
}