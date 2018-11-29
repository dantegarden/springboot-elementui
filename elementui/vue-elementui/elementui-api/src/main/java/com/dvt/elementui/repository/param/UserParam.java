package com.dvt.elementui.repository.param;

public class UserParam extends PageParam {
    private String userName;
    private String password;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserParam(Integer pageSize, Integer pageNumber, String userName, String password) {
        super(pageSize, pageNumber);
        this.userName = userName;
        this.password = password;
    }
}
