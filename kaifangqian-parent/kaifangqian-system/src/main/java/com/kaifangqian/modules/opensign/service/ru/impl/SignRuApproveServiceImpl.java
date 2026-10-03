/**
 * @description 签署审批服务接口实现
 */
package com.kaifangqian.modules.opensign.service.ru.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignRuApprove;
import com.kaifangqian.modules.opensign.mapper.SignRuApproveMapper;
import com.kaifangqian.modules.opensign.service.ru.SignRuApproveService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignRuApproveServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.ru.impl
 * @ClassName: SignRuApproveServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignRuApproveServiceImpl extends ServiceImpl<SignRuApproveMapper, SignRuApprove> implements SignRuApproveService {

    @Override
    public List<SignRuApprove> listByRuId(String ruId) {
        QueryWrapper<SignRuApprove> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRuApprove::getSignRuId,ruId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        return this.baseMapper.selectList(wrapper);
    }

}