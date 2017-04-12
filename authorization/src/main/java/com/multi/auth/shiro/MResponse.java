package com.multi.auth.shiro;

/**
 * @author shepard.xia
 * @date 2017年04月12日
 * @description input useage
 */
public class MResponse <T> {
    private String message;
    private int code;
    private T data;


    public MResponse() {
    }

    public MResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public MResponse(String message, int code, T data) {
        this(message,code);
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
