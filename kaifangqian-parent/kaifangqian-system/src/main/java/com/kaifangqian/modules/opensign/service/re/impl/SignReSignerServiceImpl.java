/**
 * @description 获取业务线签署人接口实现类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignReSigner;
import com.kaifangqian.modules.opensign.mapper.SignReSignerMapper;
import com.kaifangqian.modules.opensign.service.re.SignReSignerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReSignerServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReSignerServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReSignerServiceImpl extends ServiceImpl<SignReSignerMapper, SignReSigner> implements SignReSignerService {


    @Override
    public List<SignReSigner> listByReId(String reId) {
        QueryWrapper<SignReSigner> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReSigner::getSignReId,reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        return this.baseMapper.selectList(wrapper);
    }


}