/**
 * @description 经过计算后的文件签署位置属性类
 */
package com.kaifangqian.modules.opensign.service.tool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 经过计算后的文件签署位置属性类
 * @Package: com.kaifangqian.modules.sign.pojo
 * @ClassName: PositionProperty
 * @author: FengLai_Gong
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RealPositionProperty implements Serializable {


    private static final long serialVersionUID = 8586984409612483553L;

    /** 签章左下角x坐标 */
    private float startx;

    /** 签章左下角y坐标*/
    private float starty;

    /** 签章右上角x坐标*/
    private float endx;

    /** 签章右上角x坐标*/
    private float endy;

    private int pageNum;

    //真实pdf文件宽
    private float realPdfWidth;
    //真实pdf文件高
    private float realPdfHeight;

    // 填写值，填写专用
    private String value;
    //对齐方式
    private String align;
    //字体
    private String fontFamily;
    //文字大小
    private String fontSize;

    private String controlType;

    private String filedName;

    private List<ControlWidgetProperty> widgetPropertyList;
}