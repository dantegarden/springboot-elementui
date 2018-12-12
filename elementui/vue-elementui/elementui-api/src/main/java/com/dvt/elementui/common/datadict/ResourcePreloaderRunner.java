package com.dvt.elementui.common.datadict;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) //如果多个自定义ApplicationRunner，用来标明执行顺序
public class ResourcePreloaderRunner implements ApplicationRunner {

    private static final Logger LOGGER = Logger.getLogger(ResourcePreloaderRunner.class);

    @Autowired
    private DataDictLoader dataDictLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("开始加载字典");
        dataDictLoader.preLoad();
        LOGGER.info("加载成功");
    }
}
