package com.kaifangqian.modules.system.vo;

import lombok.Data;

/**
 * @author : zhenghuihan
 * create at:  2023/1/4  16:27
 * @description:加入企业响应参数
 */
@Data
public class JionRefuseTenantVO {
    private String id;
    //-1 拒绝 1 同意加入
    private Integer status;
    private String tanantName;
}