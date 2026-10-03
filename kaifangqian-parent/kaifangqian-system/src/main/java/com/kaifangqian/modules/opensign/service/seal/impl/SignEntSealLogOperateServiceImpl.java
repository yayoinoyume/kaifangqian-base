/**
 * @description 电子印章-企业印章管理操作记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.seal.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.common.system.vo.LoginUser;
import com.kaifangqian.common.util.MySecurityUtils;
import com.kaifangqian.modules.opensign.entity.SignEntSealLogOperate;
import com.kaifangqian.modules.opensign.enums.EntSealOperateTypeEnum;
import com.kaifangqian.modules.opensign.mapper.SignEntSealLogOperateMapper;
import com.kaifangqian.modules.opensign.service.seal.SignEntSealLogOperateService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description: SignEntSealLogOperateServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.seal.impl
 * @ClassName: SignEntSealLogOperateServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignEntSealLogOperateServiceImpl extends ServiceImpl<SignEntSealLogOperateMapper, SignEntSealLogOperate> implements SignEntSealLogOperateService {


    @Override
    public void insert(String sealId ,EntSealOperateTypeEnum entSealOperateTypeEnum){
        LoginUser currentUser = MySecurityUtils.getCurrentUser();
        SignEntSealLogOperate signEntSealLogOperate = new SignEntSealLogOperate();
        signEntSealLogOperate.setSealId(sealId);
        signEntSealLogOperate.setOperateTime(new Date());
        signEntSealLogOperate.setOperateType(entSealOperateTypeEnum.getCode());
        signEntSealLogOperate.setSysDeptId(currentUser.getDepartId());
        this.baseMapper.insert(signEntSealLogOperate);



    }



}