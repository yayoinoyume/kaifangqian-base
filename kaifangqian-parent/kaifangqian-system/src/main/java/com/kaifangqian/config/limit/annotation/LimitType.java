package com.kaifangqian.config.limit.annotation;

public enum LimitType {
    // 默认
    CUSTOMER,
    //  by ip addr
    IP,
    // by id & Method
    TOKEN
}
