package com.kaifangqian.config.limit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {

    // 资源名称，用于描述接口功能
    String name() default "";

    // 资源 key
    String key() default "";

    // key prefix
    String prefix() default "";

    // 时间的，单位秒
    int period() default 60;

    // 限制访问次数
    int count() default 10;

    // 限制类型
    LimitType limitType() default LimitType.CUSTOMER;

    OperateType operateType() default OperateType.LIMIT;

    // 预警单位时间（秒）
    int prePeriod() default 60;

    // 预警访问次数
    int preCount() default 10;

    // 告警单位时间（秒）
    int Warnperiod() default 60;

    // 告警访问次数
    int Warncount() default 10;

    //触发限制后如何处理
    LimitHandleType limitHandle() default LimitHandleType.NONE;
}
