package com.hd123.sardine.common.model;

import java.io.Serializable;

public class RestfulResponse<T> implements Serializable{
    private static final long serialVersionUID = -7143304902819898146L;

    public static final int DEFAULT_OK = 20000;
    private int code = DEFAULT_OK;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
