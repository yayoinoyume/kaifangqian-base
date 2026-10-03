/**
 * @description 印章状态管理
 */
package com.kaifangqian.modules.opensign.service.business;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.modules.opensign.entity.SignEntSeal;
import com.kaifangqian.modules.opensign.entity.SignPersonSeal;
import com.kaifangqian.modules.opensign.enums.SealStatusEnum;
import com.kaifangqian.modules.opensign.service.seal.SignEntSealService;
import com.kaifangqian.modules.opensign.service.seal.SignPersonSealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SealStatusBusinessService
 * @Package: com.kaifangqian.modules.opensign.service.business
 * @ClassName: SealStatusBusinessService
 * @author: FengLai_Gong
 */
@Service
public class SealStatusBusinessService {


    @Autowired
    private SignEntSealService entSealService ;
    @Autowired
    private SignPersonSealService personSealService ;


    /**
     * @Description #更改所有企业签章状态
     * @Param [tenantId 租户id, sealStatusEnum 签章状态]
     * @return void
     **/
    public void disableEntSeal(String tenantId){

        QueryWrapper<SignEntSeal> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignEntSeal::getSysTenantId,tenantId);
        wrapper.lambda().eq(SignEntSeal::getCreateType,1);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignEntSeal entSeal = new SignEntSeal();
        entSeal.setStatus(SealStatusEnum.UN_ENABLE.getCode());

        entSealService.update(entSeal, wrapper);


    }

    public void enableEntSeal(String tenantId , List<Integer> typeList){

        QueryWrapper<SignEntSeal> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignEntSeal::getSysTenantId,tenantId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        wrapper.lambda().in(SignEntSeal::getSealType,typeList);

        SignEntSeal entSeal = new SignEntSeal();
        entSeal.setStatus(SealStatusEnum.ENABLE.getCode());

        entSealService.update(entSeal, wrapper);

    }


    /**
     * @Description #更改所有个人签章状态
     * @Param [tenantId 租户id, sealStatusEnum 签章状态]
     * @return void
     **/
    public void changePersonSealStatus(String tenantId ,SealStatusEnum sealStatusEnum){

        QueryWrapper<SignPersonSeal> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignPersonSeal::getSysTenantId,tenantId);
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);

        SignPersonSeal personSeal = new SignPersonSeal();
        personSeal.setStatus(sealStatusEnum.getCode());

        personSealService.update(personSeal,wrapper);


    }


}