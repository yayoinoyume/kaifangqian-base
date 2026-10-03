/**
 * @description 本地线程变量
 */
package com.kaifangqian.modules.api.validation;

/**
 * @Description: com.kaifangqian.modules.api.validation.LocalData
 * @Package: PACKAGE_NAME
 * @ClassName: com.kaifangqian.modules.api.validation.LocalData
 * @author: FengLai_Gong
 */
public class LocalData {


    public static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();


}