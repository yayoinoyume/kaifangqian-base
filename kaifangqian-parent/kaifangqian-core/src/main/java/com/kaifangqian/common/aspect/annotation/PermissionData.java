/**
 * [类功能描述：数据权限注解]
 */
package com.kaifangqian.common.aspect.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: zhh
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface PermissionData {
	/**
	 * 配置菜单的组件路径,用于数据权限
	 */
	String pageComponent() default "";
    /**
     * 暂时没用
     */
    String value() default "";

    /**
     * 配置菜单功能权限标识,用于数据权限
     */
    String perms() default "";
}