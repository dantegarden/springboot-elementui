package com.dvt.elementui.common.webservice;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class WebServicePerloaderRunner implements ApplicationRunner {

    private static final Logger LOGGER = Logger.getLogger(WebServicePerloaderRunner.class);

    @Autowired
    private WebServices webServices;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("初始化WebService");
        webServices.initClients();
        LOGGER.info("初始化结束");
    }
}
