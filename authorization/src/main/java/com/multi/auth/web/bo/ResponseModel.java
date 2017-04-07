package com.multi.auth.web.bo;

/**
 * @author shepard.xia
 * @date 2017年04月07日
 * @description input useage
 */
public class ResponseModel<T> {
    private String msg;
    private int code;
    private T data;


    public ResponseModel(String msg, int code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
