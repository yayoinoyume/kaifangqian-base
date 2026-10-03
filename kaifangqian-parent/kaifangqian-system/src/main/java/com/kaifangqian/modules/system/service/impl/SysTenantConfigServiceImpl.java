package com.kaifangqian.modules.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.system.entity.SysTenantConfig;
import com.kaifangqian.modules.system.mapper.SysTenantConfigMapper;
import com.kaifangqian.common.util.MySecurityUtils;
import com.kaifangqian.modules.system.service.ISysTenantConfigService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author zhenghuihan
 * @description 租户系统配置服务类
 * @createTime 2022/9/2 18:13
 */
@Service
public class SysTenantConfigServiceImpl extends ServiceImpl<SysTenantConfigMapper, SysTenantConfig> implements ISysTenantConfigService {

    @Override
    public SysTenantConfig getConfigByType(String tenantId, String type) {
        if (MyStringUtils.isBlank(tenantId)) {
            tenantId = MySecurityUtils.getCurrentUser().getTenantId();
        }
        LambdaQueryWrapper<SysTenantConfig> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysTenantConfig::getTenantId, tenantId).eq(SysTenantConfig::getType, type);

        List<SysTenantConfig> list = list(queryWrapper);
        if (CollUtil.isEmpty(list)) {
            SysTenantConfig tem = new SysTenantConfig();
            tem.setTenantId(tenantId);
            tem.setName(type);
            tem.setType(type);
            tem.setValue("false");

            save(tem);
            return tem;
        }
        return list.get(0);
    }
}
