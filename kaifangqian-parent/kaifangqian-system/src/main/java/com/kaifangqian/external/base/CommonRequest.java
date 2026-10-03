/**
 * @description 数据请求通用封装
 */

package com.kaifangqian.external.base;

import cn.hutool.core.util.RandomUtil;
import com.kaifangqian.utils.DateUtil;
import lombok.Data;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
public class CommonRequest<T> {
    private String appId = "resrun";

    private String timestamp = String.valueOf(DateUtil.getTimestamp());

    private String nonce = String.valueOf(RandomUtil.getRandom());

    private String sign;
}
