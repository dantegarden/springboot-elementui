package com.dvt.elementui.common.exception;

import com.dvt.elementui.common.enums.HttpStatusCodeEnum;

import java.util.Objects;

/**
 * 业务异常
 *
 */
public class BusinessException extends RuntimeException {

    /**
     * 异常代码
     */
    private int errorCode = HttpStatusCodeEnum.SERVER_ERROR.getCode();
    /**
     * 异常信息
     */
    private String errorMessage;

    public BusinessException(String errorMessage) {
        this.errorCode = HttpStatusCodeEnum.SERVER_ERROR.getCode();
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errorMessage, Throwable e) {
        super(errorMessage, e);
        this.errorCode = HttpStatusCodeEnum.SERVER_ERROR.getCode();
    }

    public BusinessException(int errorCode, String errorMessage, Throwable e) {
        super(errorMessage, e);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BusinessException that = (BusinessException) o;
        return this.errorCode == that.errorCode &&
                Objects.equals(this.errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.errorCode, this.errorMessage);
    }

    public BusinessException() {
    }

    public BusinessException(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
