package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysTextConfig;

/**
 * @author zhenghuihan
 * @description 系统服务协议配置服务
 * @createTime 2022/9/2 18:13
 */
public interface ISysTextConfigService extends IService<SysTextConfig> {

    SysTextConfig getByType(String type);

}
