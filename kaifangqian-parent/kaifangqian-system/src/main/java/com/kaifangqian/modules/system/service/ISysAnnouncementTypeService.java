package com.kaifangqian.modules.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysAnnouncementType;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 系统公告类型服务
 * @createTime 2022/9/2 17:40
 */
public interface ISysAnnouncementTypeService extends IService<SysAnnouncementType> {

    void addExt(SysAnnouncementType sysAnnouncementType);

    void editExt(SysAnnouncementType sysAnnouncementType);

    void removeExt(String id);

    void removeBatchExt(List<String> ids);

    List<Tree<String>> getTreeList(List<SysAnnouncementType> list);

}
