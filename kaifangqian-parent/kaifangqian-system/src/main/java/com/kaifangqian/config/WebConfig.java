package com.kaifangqian.config;

import com.kaifangqian.interceptor.ControlInterceptor;
//import com.kaifangqian.interceptor.LogInterceptor;
import com.kaifangqian.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @description WebConfig
 */

/**
 * @author : zhh
 * create at: 2023/3/4
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ControlInterceptor controlInterceptor;

    @Autowired
    private LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //控制拦截器
        registry.addInterceptor(controlInterceptor).addPathPatterns("/**");
        //日志拦截器
        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
    }
}