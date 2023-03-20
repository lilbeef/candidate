package com.aspecta.challenge.io.exception;

/**
 * @Author: sxy
 * @Date: 2023/3/19 15:22
 */

public class ApiException extends RuntimeException {
    private int code;
    private String message;
    static final long serialVersionUID = -1L;

    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
        this.code = 9500;
        this.message = message;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    protected ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ApiException(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
