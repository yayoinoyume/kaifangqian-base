/**
 * @description Base64Utils
 */
package com.kaifangqian.common.util;

/**
 * @author : zhh
 * create at:  2022/3/16
 */
public class Base64Utils {
    public static String getBase64Pre(String type) {
        return "data:image/" + type + ";base64,";
    }
}