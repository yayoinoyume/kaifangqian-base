package com.kaifangqian.modules.system.util;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : zhenghuihan
 * create at:  2022/8/26  15:26
 * @description: 图片处理工具类
 */
public class ImageUtils {
    public static void compressImg(InputStream inputStream, File file, int width, int height) {
        try {
            Thumbnails.of(inputStream).size(width, height).toFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}