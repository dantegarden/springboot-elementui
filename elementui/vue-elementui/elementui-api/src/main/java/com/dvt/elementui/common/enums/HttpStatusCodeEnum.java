package com.dvt.elementui.common.enums;

public enum HttpStatusCodeEnum {
    /** 请求成功 **/
    SUCCESS(200),
    /** 参数错误 **/
    PARAM_ERROR(400),
    /** 限制调用 **/
    LIMIT_ERROR(401),
    /** token 过期 **/
    TOKEN_TIMEOUT(402),
    /** 禁止访问 **/
    NO_AUTH(403),
    /** 资源没找到 **/
    NOT_FOUND(404),
    /** 服务器错误 **/
    SERVER_ERROR(500);

    private int code;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    private HttpStatusCodeEnum(int code) {
        this.code = code;
    }
}
