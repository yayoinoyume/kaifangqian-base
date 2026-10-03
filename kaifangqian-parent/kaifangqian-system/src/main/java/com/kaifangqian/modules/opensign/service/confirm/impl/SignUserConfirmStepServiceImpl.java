/**
 * @description 用户意愿校验订单校验步骤记录接口实现类
 */
package com.kaifangqian.modules.opensign.service.confirm.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignUserConfirmStep;
import com.kaifangqian.modules.opensign.mapper.SignUserConfirmStepMapper;
import com.kaifangqian.modules.opensign.service.confirm.ISignUserConfirmStepService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUserConfirmStepServiceImpl extends ServiceImpl<SignUserConfirmStepMapper, SignUserConfirmStep> implements ISignUserConfirmStepService {

    @Override
    public SignUserConfirmStep getByOrderNo(String orderNo, Integer step) {
        LambdaQueryWrapper<SignUserConfirmStep> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SignUserConfirmStep::getConfirmId, orderNo).eq(SignUserConfirmStep::getStep, step).eq(SignUserConfirmStep::getDeleteFlag, false);

        List<SignUserConfirmStep> list = list(queryWrapper);
        if (CollUtil.isNotEmpty(list)) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public List<SignUserConfirmStep> getUnbindData(String confirmType) {
        LambdaQueryWrapper<SignUserConfirmStep> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.isNotNull(SignUserConfirmStep::getConfirmFlag).eq(SignUserConfirmStep::getBindDataFlag, 0).eq(SignUserConfirmStep::getConfirmType, confirmType);

        return list(queryWrapper);
    }

    @Override
    public SignUserConfirmStep getByConfirmId(String confirmId) {
        LambdaQueryWrapper<SignUserConfirmStep> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SignUserConfirmStep::getConfirmId, confirmId).eq(SignUserConfirmStep::getDeleteFlag, 0);
        List<SignUserConfirmStep> list = list(queryWrapper);
        if (CollUtil.isNotEmpty(list)) {
            return list.get(0);
        }

        return null;
    }
}