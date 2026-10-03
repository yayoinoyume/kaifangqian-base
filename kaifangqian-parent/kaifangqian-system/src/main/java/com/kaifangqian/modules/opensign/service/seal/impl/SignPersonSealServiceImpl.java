/**
 * @description 电子印章-个人印章管理接口实现类
 */
package com.kaifangqian.modules.opensign.service.seal.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignPersonSeal;
import com.kaifangqian.modules.opensign.enums.SealDefaultEnum;
import com.kaifangqian.modules.opensign.mapper.SignPersonSealMapper;
import com.kaifangqian.modules.opensign.service.seal.SignPersonSealService;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description: SignPersonSealServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.seal.impl
 * @ClassName: SignPersonSealServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignPersonSealServiceImpl extends ServiceImpl<SignPersonSealMapper, SignPersonSeal> implements SignPersonSealService {


    @Override
    public Boolean cancelDefault() {
        QueryWrapper<SignPersonSeal> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        wrapper.lambda().eq(SignPersonSeal::getIsDefault, SealDefaultEnum.IS.getCode());

        SignPersonSeal seal = new SignPersonSeal();
        seal.setIsDefault(SealDefaultEnum.NOT.getCode());
        seal.setUpdateTime(new Date());
        this.baseMapper.update(seal,wrapper);
        return true;
    }

    @Override
    public Boolean setDefault(String sealId) {
        SignPersonSeal seal = new SignPersonSeal();
        seal.setId(sealId);
        seal.setIsDefault(SealDefaultEnum.IS.getCode());
        seal.setUpdateTime(new Date());
        this.baseMapper.updateById(seal);
        return true;
    }

    @Override
    public Boolean delete(String sealId) {
        SignPersonSeal seal = new SignPersonSeal();
        seal.setId(sealId);
        seal.setDeleteFlag(true);
        seal.setDeleteTime(new Date());
        this.baseMapper.updateById(seal);
        return true;
    }
}