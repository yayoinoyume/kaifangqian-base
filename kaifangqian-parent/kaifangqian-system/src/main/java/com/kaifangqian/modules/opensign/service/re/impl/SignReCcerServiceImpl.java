/**
 * @description 签署抄送人接口实现类
 */
package com.kaifangqian.modules.opensign.service.re.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignReCcer;
import com.kaifangqian.modules.opensign.mapper.SignReCcerMapper;
import com.kaifangqian.modules.opensign.service.re.SignReCcerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignReCcerServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.re.impl
 * @ClassName: SignReCcerServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignReCcerServiceImpl extends ServiceImpl<SignReCcerMapper, SignReCcer> implements SignReCcerService {

    @Override
    public List<SignReCcer> listByReId(String reId) {
        QueryWrapper<SignReCcer> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReCcer::getSignReId,reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public void deleteByReId(String reId) {
        QueryWrapper<SignReCcer> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignReCcer::getSignReId,reId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignReCcer ccer = new SignReCcer();
        ccer.setDeleteFlag(true);

        this.baseMapper.update(ccer,wrapper);

    }
}