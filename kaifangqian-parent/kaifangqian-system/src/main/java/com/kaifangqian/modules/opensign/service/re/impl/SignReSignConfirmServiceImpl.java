/**
 * @description 业务线管理接口实现
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignReSignConfirm;
import com.kaifangqian.modules.opensign.mapper.SignReSignConfirmMapper;
import com.kaifangqian.modules.opensign.service.re.SignReSignConfirmService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReSignConfirmServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReSignConfirmServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReSignConfirmServiceImpl extends ServiceImpl<SignReSignConfirmMapper, SignReSignConfirm> implements SignReSignConfirmService {

    @Override
    public void save(String signerId, String reId, Integer signerType,Integer isFastSign, String verifyType, String personalSignAuth, String sealType) {
        SignReSignConfirm reSignConfirm = new SignReSignConfirm();
        reSignConfirm.setSignReId(reId);
        reSignConfirm.setSignerId(signerId);
        reSignConfirm.setSignerType(signerType);
        reSignConfirm.setAgreeSkipWillingness(isFastSign);
        reSignConfirm.setConfirmType(verifyType);
        reSignConfirm.setPersonalSignAuth(personalSignAuth);
        reSignConfirm.setSealType(sealType);
        save(reSignConfirm);
    }

    @Override
    public SignReSignConfirm getByParam(String signerId, String reId) {
        QueryWrapper<SignReSignConfirm> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReSignConfirm::getSignReId,reId);
        wrapper.lambda().eq(SignReSignConfirm::getSignerId,signerId);

        List<SignReSignConfirm> signConfirmList = this.baseMapper.selectList(wrapper);
        if(signConfirmList != null && signConfirmList.size() > 0){
            return signConfirmList.get(0);
        }
        return null;
    }

    @Override
    public List<SignReSignConfirm> listByParam(String reId) {
        QueryWrapper<SignReSignConfirm> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReSignConfirm::getSignReId,reId);

        List<SignReSignConfirm> signConfirmList = this.baseMapper.selectList(wrapper);
        return signConfirmList;
    }

    @Override
    public void delete(String signerId, String reId) {
        QueryWrapper<SignReSignConfirm> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReSignConfirm::getSignReId,reId);
        wrapper.lambda().eq(SignReSignConfirm::getSignerId,signerId);

        this.baseMapper.delete(wrapper);
    }

}