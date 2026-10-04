/**
 * @description 字体工具类
 */
package com.kaifangqian.modules.opensign.util;

/**
 * @Description: 字体工具类
 * @Package: com.kaifangqian.modules.opensign.util
 * @ClassName: FontUtils
 * @author: Fusion
 * CreateTime:  2023/8/22  17:53
 * @copyright 资助审批电子签章系统
 */
public class FontUtils {

    /*宋体全部：
    Name:STSong
    Name:STSongti-SC-Black
    Name:STSongti-SC-Bold
    Name:STSongti-SC-Light
    Name:STSongti-SC-Regular
    Name:STSongti-TC-Bold
    Name:STSongti-TC-Light
    Name:STSongti-TC-Regular
    */

    /*Arial字体：
    Name:Arial-Black
    Name:Arial-BoldItalicMT
    Name:Arial-BoldMT
    Name:Arial-ItalicMT*/

    /*隶书：
    Name:STBaoliSC-Regular
    Name:STBaoliTC-Regular*/

    public static final String base64Prefix="data:image/png;base64,";
    public static final String SEAL_SAVE_PATH = System.getProperty("user.dir") + "/src/main/resources/static/upload/";
    public static final String Font_LiShu = "STBaoliTC-Regular";//隶书
    public static final String Font_SongTi = "STSongti-SC-Bold";//宋体
    public static final String Font_FangSong = "STFangsong";//仿宋
    public static final String Font_KaiTi = "STKaiti";//楷体
    public static final String Font_Arial = "Arial-Black";//Arial
    public final static int INIT_BEGIN = 10;
}
