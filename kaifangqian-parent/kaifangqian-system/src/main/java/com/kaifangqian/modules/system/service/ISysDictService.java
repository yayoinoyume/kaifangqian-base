package com.kaifangqian.modules.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaifangqian.modules.system.entity.SysDict;

import java.util.List;

/**
 * @author zhenghuihan
 * @description 字典分类
 * @createTime 2022/9/2 18:12
 */
public interface ISysDictService extends IService<SysDict> {

    void saveExt(SysDict sysDict);

    void updateExt(SysDict sysDict);

    void deleteExt(String id);

    List<Tree<String>> getTreeList(List<SysDict> list);
}
