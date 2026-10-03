package com.kaifangqian.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.system.entity.SysPosition;
import com.kaifangqian.modules.system.mapper.SysPositionMapper;
import com.kaifangqian.modules.system.service.ISysPositionService;
import org.springframework.stereotype.Service;

/**
 * @author zhenghuihan
 * @description 职务表
 * @createTime 2022/9/2 18:17
 */
@Service
public class SysPositionServiceImpl extends ServiceImpl<SysPositionMapper, SysPosition> implements ISysPositionService {

    @Override
    public SysPosition getByCode(String code) {
        LambdaQueryWrapper<SysPosition> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysPosition::getCode, code);
        return super.getOne(queryWrapper);
    }

}
