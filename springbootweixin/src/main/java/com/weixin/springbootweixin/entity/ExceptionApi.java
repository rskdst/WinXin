package com.weixin.springbootweixin.entity;

/**
 * 自定义异常信息接口字段
 */

public class ExceptionApi extends RuntimeException {
    private int code;
    private String data;
    private String message;

    public ExceptionApi(int code,String data,String message) {
        this.code = code;
        this.data = data;
        this.message = message;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

