package com.kaifangqian.modules.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kaifangqian.modules.system.entity.SysDict;
import com.kaifangqian.modules.system.entity.SysDictItem;
import com.kaifangqian.modules.system.enums.DictType;
import com.kaifangqian.modules.system.mapper.SysDictItemMapper;
import com.kaifangqian.exception.PaasException;
import com.kaifangqian.modules.system.service.ISysDictItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifangqian.modules.system.service.ISysDictService;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItem> implements ISysDictItemService {

    @Autowired
    private ISysDictService iSysDictService;

    @Override
    public void saveExt(SysDictItem sysDictItem) {
        if (MyStringUtils.isBlank(sysDictItem.getParentId())) {
            sysDictItem.setParentId("");
        }
        checkEntity(sysDictItem);
        this.save(sysDictItem);
    }

    @Override
    public void updateExt(SysDictItem sysDictItem) {
        if (MyStringUtils.isBlank(sysDictItem.getParentId())) {
            sysDictItem.setParentId("");
        }
        checkEntity(sysDictItem);

        this.updateById(sysDictItem);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteExt(String id) {
        deleteItemTree(id);
    }

    void deleteItemTree(String parentId) {
        if (MyStringUtils.isNotBlank(parentId)) {
            this.removeById(parentId);
            LambdaQueryWrapper<SysDictItem> wrapper = new LambdaQueryWrapper();
            wrapper.eq(SysDictItem::getParentId, parentId);

            List<SysDictItem> result = this.list(wrapper);
            if (CollUtil.isNotEmpty(result)) {
                result.forEach(d -> {
                    deleteItemTree(d.getId());
                });
            }
        }
    }

    void checkEntity(SysDictItem sysDictItem) {
        if (MyStringUtils.isBlank(sysDictItem.getDictId())) {
            throw new PaasException("字典组ID不可以为空");
        }
        SysDict sysDict = iSysDictService.getById(sysDictItem.getDictId());
        if (sysDict == null || !DictType.DICT.getType().equals(sysDict.getType())) {
            throw new PaasException("选择的字典组不可以添加字典");
        }
    }

    @Override
    public List<Tree<String>> getTreeList(List<SysDictItem> list) {
        List<Tree<String>> treeList = TreeUtil.build(list, "", (object, tree) -> {
            tree.setId(object.getId());
            tree.setParentId(object.getParentId());
            tree.setName(object.getItemText());

            tree.putExtra("dictId", object.getDictId());
            tree.putExtra("itemValue", object.getItemValue());
            tree.putExtra("description", object.getDescription());
            tree.putExtra("sortOrder", object.getSortOrder());
            tree.putExtra("status", object.getStatus());
        });

        return treeList;
    }

    @Override
    public void deleteByDictId(String dictId) {
        if (MyStringUtils.isNotBlank(dictId)) {
            LambdaQueryWrapper<SysDictItem> wrapper = new LambdaQueryWrapper();
            wrapper.eq(SysDictItem::getDictId, dictId);

            this.remove(wrapper);
        }
    }

    @Override
    public Integer countByPId(String pId) {
        LambdaQueryWrapper<SysDictItem> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(SysDictItem::getParentId, pId);
        return (int)this.count(queryWrapper);
    }

    @Override
    public List<SysDictItem> getByIds(List<String> ids) {
        if (CollUtil.isNotEmpty(ids)) {
            return this.listByIds(ids);
        }
        return new ArrayList<>();
    }
}
