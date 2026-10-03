/**
 * @Discription:签署API开发者管理服务接口实现类
 */
package com.kaifangqian.modules.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.system.entity.ApiDeveloperManage;
import com.kaifangqian.modules.system.mapper.ApiDeveloperManageMapper;
import com.kaifangqian.common.aspect.LicenseBean;
import com.kaifangqian.common.constant.CommonConstant;
import com.kaifangqian.exception.PaasException;
import com.kaifangqian.modules.system.service.IApiDeveloperManageService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApiDeveloperManageServiceImpl extends ServiceImpl<ApiDeveloperManageMapper, ApiDeveloperManage> implements IApiDeveloperManageService {

    @Lazy
    @Resource
    private LicenseBean licenseBean;

    @Override
    public ApiDeveloperManage getByToken(String token) {
        LambdaQueryWrapper<ApiDeveloperManage> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ApiDeveloperManage::getToken, token);

        List<ApiDeveloperManage> list = this.list(queryWrapper);

        if (CollUtil.isNotEmpty(list)) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public void saveExt(ApiDeveloperManage apiDeveloperManage) {
        checkCount();
        String token = RandomUtil.randomString(CommonConstant.BASE_CHECK_CODES, 8).toUpperCase();
        while (getByToken(token) != null) {
            token = RandomUtil.randomString(CommonConstant.BASE_CHECK_CODES, 8).toUpperCase();
        }

        apiDeveloperManage.setToken(token);
        if (apiDeveloperManage.getStatus() == null) {
            apiDeveloperManage.setStatus(1);
        }
        this.save(apiDeveloperManage);
    }

    void checkCount() {
        int count = (int) count();
        if (count >= licenseBean.getGrant().getApiAuthorizationCeiling()) {
            throw new PaasException("只能创建" + licenseBean.getGrant().getApiAuthorizationCeiling() + "个接口授权凭证");
        }
    }

    @Override
    public void updateExt(ApiDeveloperManage apiDeveloperManage) {
        apiDeveloperManage.setToken(null);
        this.updateById(apiDeveloperManage);
    }

    @Override
    public void updateStatus(ApiDeveloperManage apiDeveloperManage) {
        apiDeveloperManage.setToken(null);
        this.updateById(apiDeveloperManage);
    }
}
