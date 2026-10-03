/**
 * @description 印章字体类
 */
package com.kaifangqian.modules.opensign.seal;

import lombok.Data;

/**
 * @Description: 印章字体类
 */
@Data
public class SealFont {
    /**
     * 字体内容
     */
    private String fontText;
    /**
     * 是否加粗
     */
    private boolean bold = true;
    /**
     * 字形名，默认为宋体
     */
    private String fontFamily = "宋体";
    /**
     * 字体大小
     */
    private Integer fontSize;
    /**
     * 字距
     */
    private Double fontSpace;
    /**
     * 边距（环边距或上边距）
     */
    private Integer marginSize;

    /**
     * 左侧距离
     */
    private Integer leftSpace = 0;


    /**
     * 拉伸（拉长长度+压缩宽度）
     */
    private Integer scale = 2;
}
