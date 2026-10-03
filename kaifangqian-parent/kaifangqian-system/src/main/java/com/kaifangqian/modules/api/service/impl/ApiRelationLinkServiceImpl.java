/**
 * @description API关系链服务类类
 */
package com.kaifangqian.modules.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.api.entity.ApiRelationLink;
import com.kaifangqian.modules.api.mapper.ApiRelationLinkMapper;
import com.kaifangqian.modules.api.service.IApiRelationLinkService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 表
 * @createTime 2022/9/2 18:05
 */
@Service
public class ApiRelationLinkServiceImpl extends ServiceImpl<ApiRelationLinkMapper, ApiRelationLink> implements IApiRelationLinkService {

    @Override
    public String getSystemIdByExAccount(String token, String type, String exAccount) {
        LambdaQueryWrapper<ApiRelationLink> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ApiRelationLink::getToken, token).eq(ApiRelationLink::getType, type).eq(ApiRelationLink::getExternalAccount, exAccount);

        List<ApiRelationLink> list = super.list(queryWrapper);
        if (CollUtil.isNotEmpty(list)) {
            return list.get(0).getSystemId();
        }
        return null;
    }

    @Override
    public void removeByExAccount(String token, String type, String exAccount) {
        LambdaQueryWrapper<ApiRelationLink> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ApiRelationLink::getToken, token).eq(ApiRelationLink::getType, type).eq(ApiRelationLink::getExternalAccount, exAccount);

        this.remove(queryWrapper);
    }

    @Override
    public void removeBySystemIds(String type, List<String> systemIds) {
        LambdaQueryWrapper<ApiRelationLink> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ApiRelationLink::getType, type)
                .in(ApiRelationLink::getExternalAccount, systemIds);

        this.remove(queryWrapper);
    }
}
