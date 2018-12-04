package com.hd123.sardine.common.model;

import com.hd123.sardine.common.RestStatus;
import com.hd123.sardine.common.util.SerializationUtils;

import java.io.Serializable;

public class ErrorEntity implements Serializable{
    private static final long serialVersionUID = 3510224421750657701L;
    private int code;
    private String msg;
    private Object details;

    public ErrorEntity(RestStatus statusCodes) {
        this(statusCodes, null);
    }

    public ErrorEntity(RestStatus statusCodes, Object details) {
        this.code = statusCodes.code();
        this.msg = statusCodes.message();
        if (details != null) {
            this.details = details;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "code: " + code +
                ", msg: '" + msg + '\'' +
                ", details: " + SerializationUtils.parse(details) +
                '}';
    }
}
