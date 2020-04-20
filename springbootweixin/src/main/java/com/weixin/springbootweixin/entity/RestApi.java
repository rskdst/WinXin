package com.weixin.springbootweixin.entity;

import lombok.Data;

/**
 * 自定义接口规范
 * @param <T>
 */
@Data
public class RestApi<T> {
    private int code;
    private T data;
    private String message;

    public RestApi(int code, T data, String message){
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
