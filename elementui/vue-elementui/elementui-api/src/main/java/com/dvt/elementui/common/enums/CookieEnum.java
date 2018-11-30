package com.dvt.elementui.common.enums;

/**
 * Cookie枚举
 *
 * @author dazzlzy
 * @date 2018/5/26
 */
public enum CookieEnum {
    /**
     * REMEMBER_ME： Cookie中存储的REMEMBER_ME
     */
    REMEMBER_ME("rememberMe"),;

    private String value;

    CookieEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
