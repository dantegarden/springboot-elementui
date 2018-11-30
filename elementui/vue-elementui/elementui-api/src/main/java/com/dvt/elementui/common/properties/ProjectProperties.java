package com.dvt.elementui.common.properties;

import com.dvt.elementui.common.enums.EnvironmentEnum;
import com.dvt.elementui.common.enums.EnvironmentGroupEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目配置
 */
@Repository
@ConfigurationProperties("project")
public class ProjectProperties {

    /**
     * 工程名
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 工程描述
     */
    private String description;

    /**
     * 项目组织标识
     */
    private String groupId;

    /**
     * 项目标识
     */
    private String artifactId;

    /**
     * 项目根目录
     */
    private String basedir;

    /**
     * 核心项目包
     */
    private String corePackage;

    /**
     * 业务项目包
     */
    private String servicePackage;

    /**
     * 当前环境值
     */
    private String[] env;

    /**
     * 注入的spring环境上下文
     */
    private final Environment environment;

    @Autowired
    public ProjectProperties(Environment environment) {
        this.environment = environment;
        this.env = environment.getActiveProfiles();
    }

    /**
     * 是否是生产环境
     * 从运行环境中读取最后一个是否为生产环境
     *
     * @return boolean 是否为生产环境
     */
    public boolean isProduct() {
        List<String> runtimeEnvs = new ArrayList<>();
        for (String s : this.env) {
            if (EnvironmentGroupEnum.isRuntime(s)) {
                runtimeEnvs.add(s);
            }
        }
        if (runtimeEnvs.size() == 0) {
            return false;
        }
        //最后一个运行环境, 如果spring.profiles.active=dev, prod, mysql  则运行环境为dev, prod, 最后一个运行环境为prod，是生产环境
        String env = runtimeEnvs.get(runtimeEnvs.size() - 1);
        return EnvironmentEnum.PROD.getName().equals(env);
    }

}
