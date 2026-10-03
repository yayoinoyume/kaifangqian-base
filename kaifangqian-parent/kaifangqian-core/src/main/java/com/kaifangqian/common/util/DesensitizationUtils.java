/**
 * @description 数据脱敏工具类
 */
package com.kaifangqian.common.util;

import com.kaifangqian.utils.MyStringUtils;

/**
 * @author : zhh
 * create at:  2022/3/16
 */
public class DesensitizationUtils {
    /**
     * 手机号用****号隐藏中间数字
     *
     * @param phone
     * @return
     */
    public static String getPhone(String phone) {
        if (MyStringUtils.isNotBlank(phone)) {
            return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        }
        return phone;
    }


    /**
     * 邮箱用****号隐藏前面的字母
     *
     * @return
     */
    public static String getEmail(String email) {
        if (MyStringUtils.isNotBlank(email)) {
            return email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
        }
        return email;
    }

    /**
     * 身份证号用****号隐藏中间数字
     *
     * @param idNumber
     * @return
     */
    public static String getIdNumber(String idNumber) {
        if (MyStringUtils.isNotBlank(idNumber)) {
            return idNumber.replaceAll("(\\d{6})\\d+(\\w{4})", "$1*****$2");
        }
        return idNumber;
    }

    /**
     *  脱敏
     * @param str 待脱敏字符串
     * @param left 左边保留多少位
     * @param right 右边保留多少位
     * @return 脱敏结果，除左右外，其余字符将被替换为*
     */
    public static String around(String str, int left, int right){
        String result = "*";
        if (str == null || (str.length() < left + right +1)){
            return str;
        }
        String regex = String.format("(?<=\\w{%d})\\w(?=\\w{%d})", left, right);
        return str.replaceAll(regex, result);
    }
}