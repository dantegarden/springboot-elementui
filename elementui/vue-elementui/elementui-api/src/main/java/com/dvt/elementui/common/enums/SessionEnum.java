package com.dvt.elementui.common.enums;

/**
 * Session枚举
 *
 * @author zhaozhenyao
 * @date 2018/5/10
 */
public enum SessionEnum {

    /**
     * CURRENT_USER: session中存储的当前用户
     */
    CURRENT_USER("CURRENT_USER"),
    USER_INFO("USER_INFO"),
    USER_PERMISSION("USER_PERMISSION");

    private String value;

    SessionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
