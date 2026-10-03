/**
 * @description 印章配置类
 */
package com.kaifangqian.modules.opensign.seal;

import lombok.Data;

import java.awt.*;

/**
 * @Description: 印章配置类
 */
@Data
public class SealConfiguration {
    /**
     * 主文字
     */
    private SealFont mainFont;
    /**
     * 副文字
     */
    private SealFont viceFont;
    /**
     * 抬头文字
     */
    private SealFont titleFont;
    /**
     * 中心文字
     */
    private SealFont centerFont;
    /**
     * 边线圆
     */
    private SealCircle borderCircle;
    /**
     * 背景色，默认红色
     */
    private Color backgroudColor = Color.RED;
    /**
     * 图片输出尺寸，默认300
     */
    /**
     * 半径
     */
    private Integer width = 400;
    /**
     * 半径
     */
    private Integer height = 400;
}
