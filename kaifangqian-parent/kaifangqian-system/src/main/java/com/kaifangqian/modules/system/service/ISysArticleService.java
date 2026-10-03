package com.kaifangqian.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysArticle;

/**
 * @author zhenghuihan
 * @description 系统发布服务
 * @createTime 2022/9/2 17:40
 */
public interface ISysArticleService extends IService<SysArticle> {

    void saveExt(SysArticle sysArticle);

    void updateExt(SysArticle sysArticle);

    IPage<SysArticle> pageExt(Page<SysArticle> page, SysArticle sysArticle);

}
