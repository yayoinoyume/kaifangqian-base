/**
 * @description 签署数据
 */
package com.kaifangqian.modules.api.controller;

import lombok.Data;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: DataSafeVo
 * @Package: com.kaifangqian.modules.api.controller
 * @ClassName: DataSafeVo
 * @author: FengLai_Gong
 * @Date: 2024/5/17
 */
@Data
public class DataSafeVo implements Serializable {

    private AtomicBoolean flag = new AtomicBoolean();

    private AtomicInteger count = new AtomicInteger();
}