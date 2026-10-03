package com.kaifangqian.modules.opensign.vo.request.ru;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2023/11/20  14:32
 * @description:功能菜单属性
 */
@Data
public class MenuStasticsVO {
    //所有文档
    private long allCount;
    //待我处理
    private long myCount;
    //待他人处理
    private long otherCount;
    //未完成
    private long runningCount;
    //已完成
    private long finishCount;
    //已失效
    private long invalidCount;
}