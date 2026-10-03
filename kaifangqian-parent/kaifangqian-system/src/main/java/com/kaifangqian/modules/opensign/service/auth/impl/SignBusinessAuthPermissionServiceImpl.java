/**
 * @description 签署业务服务接口实现类，获取签章业务权限
 */
package com.kaifangqian.modules.opensign.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.opensign.entity.SignBusinessAuthPermission;
import com.kaifangqian.modules.opensign.mapper.SignBusinessAuthPermissionMapper;
import com.kaifangqian.modules.opensign.service.auth.SignBusinessAuthPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: SignBusinessAuthPermissionServiceImpl
 * @Package: com.kaifangqian.modules.opensign.service.auth.impl
 * @ClassName: SignBusinessAuthPermissionServiceImpl
 * @author: FengLai_Gong
 */
@Service
public class SignBusinessAuthPermissionServiceImpl extends ServiceImpl<SignBusinessAuthPermissionMapper, SignBusinessAuthPermission> implements SignBusinessAuthPermissionService {


    @Override
    public List<SignBusinessAuthPermission> getList(Integer businessType, Integer businessTypeRole) {
        QueryWrapper<SignBusinessAuthPermission> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignBusinessAuthPermission::getBusinessType,businessType);
        wrapper.lambda().eq(SignBusinessAuthPermission::getBusinessTypeRole,businessTypeRole);

        return this.baseMapper.selectList(wrapper);
    }




}