/**
 * @description 圆章对象类
 */
package com.kaifangqian.modules.opensign.seal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Description: 印章圆圈类
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SealCircle {
    /**
     * 线宽度
     */
    private Integer lineSize;
    /**
     * 半径
     */
    private Integer width;
    /**
     * 半径
     */
    private Integer height;
}
