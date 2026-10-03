package com.kaifangqian.modules.system.vo;

import cn.hutool.core.lang.tree.Tree;
import lombok.Data;

import java.util.List;

/**
 * @author : zhenghuihan
 * create at:  2023/4/3  16:09
 * @description:
 */
@Data
public class AppSysPermissionVO {
    private String appId;
    private String appName;

    private List<Tree<String>> permissions;
}