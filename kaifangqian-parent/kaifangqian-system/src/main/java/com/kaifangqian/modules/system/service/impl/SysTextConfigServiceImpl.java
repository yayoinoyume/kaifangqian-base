package com.kaifangqian.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.system.entity.SysTextConfig;
import com.kaifangqian.modules.system.mapper.SysTextConfigMapper;
import com.kaifangqian.modules.system.service.ISysTextConfigService;
import org.springframework.stereotype.Service;
/**
 * @author zhenghuihan
 * @description 系统服务协议配置服务
 * @createTime 2022/9/2 18:13
 */
@Service
public class SysTextConfigServiceImpl extends ServiceImpl<SysTextConfigMapper, SysTextConfig> implements ISysTextConfigService {


    @Override
    public SysTextConfig getByType(String type) {
        LambdaQueryWrapper<SysTextConfig> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(SysTextConfig::getType, type);

        return this.getOne(queryWrapper);
    }
}
