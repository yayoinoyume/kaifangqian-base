package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.SysAppInfo;
import com.kaifangqian.modules.system.vo.AppInfoVO;
import com.kaifangqian.modules.system.vo.SysAppInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
/**
 * @author zhenghuihan
 * @description 系统应用服务
 * @createTime 2022/9/2 17:40
 */
public interface ISysAppInfoService extends IService<SysAppInfo> {

    IPage<SysAppInfo> pageExt(Page<SysAppInfo> page, QueryWrapper<SysAppInfo> queryWrapper);

    SysAppInfo getByAppCode(String appCode);

    void saveExt(SysAppInfo sysAppInfo);

    void updateStatus(SysAppInfo sysAppInfo);

    void updateExt(SysAppInfo sysAppInfo);

    void deleteExt(String id);

    void deleteBatchExt(List<String> ids);

    /**
     * @description 查询可用的应用
     */
    List<SysAppInfoVO> listAllAppsByTypes(List<Integer> types, Boolean defaultFlag);

    String getBase64ByFileId(String fileId);

    List<AppInfoVO> getAll();
}
