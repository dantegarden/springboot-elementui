package com.dvt.elementui.common.bean;

import com.dvt.elementui.common.enums.HttpStatusCodeEnum;

public class Result {
    private Boolean status = true;
    private int code = 200;
    private String message;
    private Object data;

    public static Result ok(Object data) {
        return new Result(data);
    }

    public static Result fail() {
        return new Result(false, null);
    }

    public static Result fail(String message) {
        return new Result(false, message);
    }

    public static Result fail(String message, int code) {
        return new Result(false, message, code);
    }

    public static Result failByParam(String message) {
        return new Result(false, message, HttpStatusCodeEnum.PARAM_ERROR.getCode());
    }

    public Result(Object data) {
        super();
        this.data = data;
    }

    public Result(boolean status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public Result(boolean status, String message, int code) {
        super();
        this.status = status;
        this.message = message;
        this.code = code;
    }


    public Result() {
        super();
    }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
