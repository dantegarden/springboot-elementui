package com.dvt.elementui.common.configuration;

import com.slyak.spring.jpa.FreemarkerSqlTemplates;
import com.slyak.spring.jpa.GenericJpaRepositoryFactoryBean;
import com.slyak.spring.jpa.GenericJpaRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//your base package
@ComponentScan({"com.slyak","com.dvt.elementui"})
@EnableJpaRepositories(
        basePackages = "com.dvt.elementui.biz.dao" ,
        repositoryBaseClass = GenericJpaRepositoryImpl.class,
        repositoryFactoryBeanClass = GenericJpaRepositoryFactoryBean.class)
public class RepositoryConfig {

    @Bean
    public FreemarkerSqlTemplates freemarkerSqlTemplates() {
        FreemarkerSqlTemplates templates = new FreemarkerSqlTemplates();
        templates.setSuffix(".sftl");
        //templates.setTemplateLocation("classpath:/sqls"); //模板文件的位置
        return templates;
    }
}
