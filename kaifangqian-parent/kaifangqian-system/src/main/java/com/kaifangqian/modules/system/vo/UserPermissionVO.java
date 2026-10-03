package com.kaifangqian.modules.system.vo;

import cn.hutool.core.lang.tree.Tree;
import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2022/6/27  18:07
 * @description:
 */
@Data
public class UserPermissionVO {
    private List<Tree<String>> menuTree;
    private List<String> authList;
}