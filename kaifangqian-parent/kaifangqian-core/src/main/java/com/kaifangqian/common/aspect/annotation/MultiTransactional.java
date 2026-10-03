/**
 * @description: 多数据源事务问题
 * 实现思路：转换为单数据源事务，最终类似在方法上加两个事务注解，最终还是用spring事务。
 * 因为spring不支持加两个事务注解，所以通过该方法，将多数据源事务转换成单数据源事务问题。
 * 存在问题：因为不是分布式事务的解决方案，所以当数据库宕机或其他不可控因素发生时，也会存在一些问题。
 */
package com.kaifangqian.common.aspect.annotation;

import java.lang.annotation.*;

/**
 * @author : zhh
 * create at:  2021/2/3  5:26 PM
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MultiTransactional {

    /**
     * 事务管理器数组
     */
    String[] value() default {};
}
