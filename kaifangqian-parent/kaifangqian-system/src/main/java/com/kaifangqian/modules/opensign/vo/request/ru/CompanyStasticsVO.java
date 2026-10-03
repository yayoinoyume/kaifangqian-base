/**
 * @description 任务属性
 */
package com.kaifangqian.modules.opensign.vo.request.ru;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2023/11/20  14:32
 * @description:
 */
@Data
public class CompanyStasticsVO {
    //进行中 填写中、签署中
    private Integer statusCount;
    //已拒填
    private Integer status6Count;
    //已拒签
    private Integer status8Count;
    //已撤回（撤销）
    private Integer status10Count;
    //已失效（预期）
    private Integer status9Count;
    //已完成
    private Integer status11Count;
}