/**
 * @description 产品发布Mapper
 */
package com.kaifangqian.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaifangqian.modules.system.entity.SysArticle;

public interface SysArticleMapper extends BaseMapper<SysArticle> {
    IPage<SysArticle> pageExt(Page page, @org.apache.ibatis.annotations.Param("sysArticle") SysArticle sysArticle);

    IPage<SysArticle> pageExt2(Page page, @org.apache.ibatis.annotations.Param("sysArticle") SysArticle sysArticle);
}
