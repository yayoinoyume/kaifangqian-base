package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysTenantUserFast;
import com.kaifangqian.modules.system.vo.SysTenantUserFastVO;

import java.util.List;
/**
 * @author zhenghuihan
 * @description 租户用户快捷操作服务类
 * @createTime 2022/9/2 18:13
 */
public interface ISysTenantUserFastService extends IService<SysTenantUserFast> {

    List<SysTenantUserFastVO> myFast();

    void updateExt(List<SysTenantUserFastVO> sysTenantUserFastVOS);
}
