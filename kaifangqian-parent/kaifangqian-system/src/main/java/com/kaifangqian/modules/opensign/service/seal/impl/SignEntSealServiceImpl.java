/**
 * @description 电子印章-企业印章管理接口实现类
 */
package com.kaifangqian.modules.opensign.service.seal.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignEntSeal;
import com.kaifangqian.modules.opensign.enums.EntSealApplyStatusEnum;
import com.kaifangqian.modules.opensign.enums.EntSealStatusEnum;
import com.kaifangqian.modules.opensign.mapper.SignEntSealMapper;
import com.kaifangqian.modules.opensign.service.seal.SignEntSealService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignEntSealServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.doc.impl
 * @ClassName: SignEntSealServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignEntSealServiceImpl extends ServiceImpl<SignEntSealMapper, SignEntSeal> implements SignEntSealService {



    @Override
    public List<SignEntSeal> getList(String tenantId) {

        QueryWrapper<SignEntSeal> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignEntSeal::getSysTenantId,tenantId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().orderByDesc(BaseEntity::getCreateTime);
        List<SignEntSeal> signEntSeals = this.baseMapper.selectList(wrapper);

        return signEntSeals;
    }

    @Override
    public Boolean updateStatus(EntSealStatusEnum entSealStatus, EntSealApplyStatusEnum entSealApplyStatus, String sealId) {

        SignEntSeal entSeal = new SignEntSeal();
        entSeal.setId(sealId);
//        if(entSealApplyStatus != null){
//            entSeal.setApplyStatus(entSealApplyStatus.getCode());
//        }
        if(entSealStatus != null){
            entSeal.setSealStatus(entSealStatus.getCode());
        }

        int i = this.baseMapper.updateById(entSeal);
        if(i > 0){
            return true;
        }

        return false;
    }
}