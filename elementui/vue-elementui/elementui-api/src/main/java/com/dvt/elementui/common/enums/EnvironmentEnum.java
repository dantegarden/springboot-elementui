package com.dvt.elementui.common.enums;


/**
 * 运行环境枚举
 *
 * @author dazzlzy
 * @date 2018/5/26
 */
public enum EnvironmentEnum {

    /**
     * 开发环境
     */
    DEV("dev"),
    /**
     * 生产环境
     */
    PROD("prod"),;

    private String name;

    EnvironmentEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
