package com.dvt.elementui.common.configuration;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.dvt.elementui.common.filter.HTTPBasicAuthorizeFilter;
/**全局注册Filter**/
@Configuration
public class FilterConfig {
	
//	@Bean
//    public FilterRegistrationBean  filterRegistration() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new HTTPBasicAuthorizeFilter());
//        // 需要过滤的url集合
//        List<String> urlPatterns = new ArrayList<String>(1);
//        urlPatterns.add("/*");
//        registrationBean.setUrlPatterns(urlPatterns);
//        // 初始化的参数
//        //registrationBean.addInitParameter("paramName", "paramValue");
//        // 过滤器的名称
//        registrationBean.setName("HTTPBasicAuthorizeFilter");
//        // 过滤器的执行顺序，order 从小到大顺序执行
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }
	
}
