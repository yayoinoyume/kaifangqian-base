package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysPosition;

/**
 * @author zhenghuihan
 * @description 职务表
 * @createTime 2022/9/2 18:13
 */
public interface ISysPositionService extends IService<SysPosition> {

    /**
     * 通过code查询
     */
    SysPosition getByCode(String code);

}
