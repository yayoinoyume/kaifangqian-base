package com.kaifangqian.modules.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.kaifangqian.modules.system.entity.SysDictItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 字典组
 * @createTime 2022/9/2 18:12
 */
public interface ISysDictItemService extends IService<SysDictItem> {
    void saveExt(SysDictItem sysDictItem);

    void updateExt(SysDictItem sysDictItem);

    void deleteExt(String id);

    List<Tree<String>> getTreeList(List<SysDictItem> list);

    void deleteByDictId(String dictId);

    Integer countByPId(String pId);

    List<SysDictItem> getByIds(List<String> ids);
}
