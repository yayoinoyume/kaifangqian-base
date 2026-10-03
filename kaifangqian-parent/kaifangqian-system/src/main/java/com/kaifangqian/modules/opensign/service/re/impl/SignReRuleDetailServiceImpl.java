/**
 * @description 业务线编码规则细则生成接口实现类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignReRuleDetail;
import com.kaifangqian.modules.opensign.mapper.SignReRuleDetailMapper;
import com.kaifangqian.modules.opensign.service.re.SignReRuleDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReRuleDetailServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReRuleDetailServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReRuleDetailServiceImpl extends ServiceImpl<SignReRuleDetailMapper, SignReRuleDetail> implements SignReRuleDetailService {


    @Override
    public void deleteByRuleId(String ruleId) {
        QueryWrapper<SignReRuleDetail> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReRuleDetail::getRuleId,ruleId);
        this.baseMapper.delete(wrapper);
    }

    @Override
    public List<SignReRuleDetail> listByRuleId(String ruleId) {
        QueryWrapper<SignReRuleDetail> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReRuleDetail::getRuleId,ruleId);
        return this.baseMapper.selectList(wrapper);
    }


}