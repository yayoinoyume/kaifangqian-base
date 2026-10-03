/**
 * @description 业务线编码规则生成接口实现类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignReRule;
import com.kaifangqian.modules.opensign.mapper.SignReRuleMapper;
import com.kaifangqian.modules.opensign.service.re.SignReRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReRuleServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReRuleServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReRuleServiceImpl extends ServiceImpl<SignReRuleMapper, SignReRule> implements SignReRuleService {

    @Override
    public List<SignReRule> listByReId(String reId, Integer ruleType) {
        QueryWrapper<SignReRule> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReRule::getSignReId,reId);
        wrapper.lambda().eq(SignReRule::getRuleType,ruleType);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        return this.baseMapper.selectList(wrapper);
    }

}