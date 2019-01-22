package com.dvt.elementui.common.configuration;

import com.dvt.elementui.biz.webservice.MyWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * 此示例暴露服务 http://localhost:8088/ws/user?wsdl
 * 如果需要发布多个webservice，需要配置多个Config实现类文件
 * **/

@Configuration
public class WebServiceConfig {

    @Autowired
    private MyWebService myWebService;


    @Bean
    public ServletRegistrationBean dispatcherWSServlet() {
        //注意此处方法名，如用dispatcherServlet会把默认映射覆盖掉
        //默认服务在Host:port/services/*路径下
        return new ServletRegistrationBean(new CXFServlet(),"/ws/*");//发布服务名称
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint=new EndpointImpl(springBus(), myWebService);//绑定要发布的服务
        endpoint.publish("/user"); //显示要发布的名称
        return endpoint;
    }

}
