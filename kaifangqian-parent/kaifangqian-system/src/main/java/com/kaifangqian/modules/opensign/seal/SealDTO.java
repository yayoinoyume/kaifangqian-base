/**
 * @description 印章数据类
 */
package com.kaifangqian.modules.opensign.seal;

import lombok.Data;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

@Data
public class SealDTO {
    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 颜色
     */
    private Integer color = 0;

    /**
     * 下弦文
     */
    private String serNo;
    /**
     * 五角星
     */
    private boolean starFlag = true;

    /**
     * 中间文字
     */
    private String center;

    /**
     * 副标题
     */
    private String title;

    /**
     * 颜色的集合
     */
    private static List<Color> colorList = Arrays.asList(Color.RED, Color.BLUE, Color.BLACK);


    public Color getColor() {
        return color > colorList.size() ? colorList.get(0) : colorList.get(color);
    }
}
