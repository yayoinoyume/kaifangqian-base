package com.kaifangqian.modules.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.system.entity.SysArticle;
import com.kaifangqian.modules.system.mapper.SysArticleMapper;
import com.kaifangqian.modules.system.service.ISysArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
/**
 * @author zhenghuihan
 * @description 系统发布服务
 * @createTime 2022/9/2 17:40
 */
@Service
public class SysArticleServiceImpl extends ServiceImpl<SysArticleMapper, SysArticle> implements ISysArticleService {

    @Resource
    private SysArticleMapper mapper;

    @Override
    public void saveExt(SysArticle sysArticle) {
        if (sysArticle.getStatus() == 1) {
            sysArticle.setPublishTime(new Date());
        }
        sysArticle.setUpdateTime(new Date());
        save(sysArticle);
    }

    @Override
    public void updateExt(SysArticle sysArticle) {
        if (sysArticle.getStatus() == 1) {
            sysArticle.setPublishTime(new Date());
        }
        updateById(sysArticle);
    }

    @Override
    public IPage<SysArticle> pageExt(Page<SysArticle> page, SysArticle sysArticle) {
        if (sysArticle.getOrder() == 2) {
            return mapper.pageExt(page, sysArticle);
        } else {
            return mapper.pageExt2(page, sysArticle);
        }
    }
}
