package com.dvt.elementui.biz.vo;

public class AuthVO {
    private String username;
    private String password;

    public AuthVO() {
    }

    public AuthVO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
