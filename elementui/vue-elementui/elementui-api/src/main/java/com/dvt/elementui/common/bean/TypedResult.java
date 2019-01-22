package com.dvt.elementui.common.bean;

import com.dvt.elementui.common.enums.HttpStatusCodeEnum;

public class TypedResult<T> extends Result {

    public TypedResult(){
        super();
    }

    public TypedResult(Boolean success, String msg, T typedDatas) {
        super(success, msg);
        this.typedDatas = typedDatas;
    }

    public TypedResult(T typedDatas) {
        super();
        this.typedDatas = typedDatas;
    }

    public TypedResult(boolean status, String message) {
        super(status, message);
    }

    public TypedResult(boolean status, String message, int code) {
        super(status, message, code);
    }

    private T typedDatas;

    @Override
    public T getData() {
        return typedDatas;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setData(Object data) {
        this.typedDatas = (T) data;
    }

    public static TypedResult ok(Object data) {
        return new TypedResult(data);
    }

    public static TypedResult fail() {
        return new TypedResult(false, null);
    }

    public static TypedResult fail(String message) {
        return new TypedResult(false, message);
    }

    public static TypedResult fail(String message, int code) {
        return new TypedResult(false, message, code);
    }

    public static TypedResult failByParam(String message) {
        return new TypedResult(false, message, HttpStatusCodeEnum.PARAM_ERROR.getCode());
    }
}
