package com.dvt.elementui.common.configuration;

import org.apache.logging.log4j.web.Log4jServletFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static javax.servlet.DispatcherType.*;

@Configuration
public class Log4jConfig {
    @Bean
    public FilterRegistrationBean log4jServletFilter() {
        FilterRegistrationBean<Log4jServletFilter> filterRegistrationBean = new FilterRegistrationBean<>(new Log4jServletFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setDispatcherTypes(REQUEST, FORWARD, INCLUDE, ERROR, ASYNC);
        return filterRegistrationBean;
    }
}
