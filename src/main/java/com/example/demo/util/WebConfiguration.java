/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.example.demo.util;

import com.example.demo.filter.MyFilter;
import com.example.demo.filter.MyFilter2;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongyuan.Yang
 * @Title: WebConfiguration
 * @Description: (自定义Filter)
 * @date 2019-02-14 11:31
 */
@Configuration
public class WebConfiguration {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        // 过滤应用程序中所有资源,当前应用程序根下的所有文件包括多级子目录下的所有文件
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        // 指定过滤器顺序，数字越小优先级越高：1>2>3...
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter2());
        // 过滤应用程序中所有资源,当前应用程序根下的所有文件包括多级子目录下的所有文件
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter2");
        // 指定过滤器顺序，数字越小优先级越高：1>2>3...
        registration.setOrder(2);
        return registration;
    }
}

