/**
 * @description 模板申请数据记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.template.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignTemplateLogApply;
import com.kaifangqian.modules.opensign.mapper.SignTemplateLogApplyMapper;
import com.kaifangqian.modules.opensign.service.template.SignTemplateLogApplyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignTemplateApplyLogServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.template.impl
 * @ClassName: SignTemplateApplyLogServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignTemplateLogApplyServiceImpl extends ServiceImpl<SignTemplateLogApplyMapper, SignTemplateLogApply> implements SignTemplateLogApplyService {

    @Override
    public SignTemplateLogApply findByTemplateId(String templateId) {
        QueryWrapper<SignTemplateLogApply> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignTemplateLogApply::getTemplateId,templateId);
        wrapper.lambda().eq(SignTemplateLogApply::getDeleteFlag,false);
        wrapper.lambda().orderByDesc(SignTemplateLogApply::getApplyTime);
        List<SignTemplateLogApply> signTemplateLogApplies = this.baseMapper.selectList(wrapper);
        if(signTemplateLogApplies != null && signTemplateLogApplies.size() > 0){
            return signTemplateLogApplies.get(0);
        }
        return null;
    }

    @Override
    public List<SignTemplateLogApply> findList(String templateId) {
        QueryWrapper<SignTemplateLogApply> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignTemplateLogApply::getTemplateId,templateId);
        wrapper.lambda().eq(SignTemplateLogApply::getDeleteFlag,false);
        List<SignTemplateLogApply> signTemplateLogApplies = this.baseMapper.selectList(wrapper);
        return signTemplateLogApplies;
    }

}