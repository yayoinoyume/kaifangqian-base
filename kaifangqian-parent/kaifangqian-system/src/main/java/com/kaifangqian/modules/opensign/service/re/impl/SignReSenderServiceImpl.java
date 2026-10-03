/**
 * @description 获取业务线发起人接口实现类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignReSender;
import com.kaifangqian.modules.opensign.mapper.SignReSenderMapper;
import com.kaifangqian.modules.opensign.service.re.SignReSenderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReSenderServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReSenderServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReSenderServiceImpl extends ServiceImpl<SignReSenderMapper, SignReSender> implements SignReSenderService {


    @Override
    public List<SignReSender> listBySignerId(String signerId) {
        QueryWrapper<SignReSender> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReSender::getSignerId,signerId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        return this.baseMapper.selectList(wrapper);
    }


}