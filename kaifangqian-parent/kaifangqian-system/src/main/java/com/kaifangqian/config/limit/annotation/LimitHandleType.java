package com.kaifangqian.config.limit.annotation;

/**
 * 此类型仅在token模式下支持
 */
public enum LimitHandleType {
        //不做任何处理
        NONE,
        //登出
        LOGOUT,
        //登出 禁用并加入黑名单
        LOGOUT_DISABLE,
        //ip模式下将ip加入白名单
        ADD_BLACKLIST

}
