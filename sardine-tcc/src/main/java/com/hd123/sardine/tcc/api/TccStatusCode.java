package com.hd123.sardine.tcc.api;

import com.google.common.collect.ImmutableMap;
import com.hd123.sardine.common.RestStatus;

public enum TccStatusCode implements RestStatus{
    OK(20000, "请求成功"),
    INVALID_MODEL_FIELDS(40001, "字段校验非法"),
    INVALID_PARAMS_CONVERSION(40002, "参数类型非法"),
    HTTP_MESSAGE_NOT_READABLE(41001, "HTTP消息不可读"),
    REQUEST_METHOD_NOT_SUPPORTED(41002, "不支持的HTTP请求方法"),
    DUPLICATE_KEY(42001, "操作过快, 请稍后再试"),
    SERVICE_INITIALIZING(42002, "服务注册中, 请稍后再试"),
    RESERVATION_CONFLICT(42003, "预留资源确认冲突"),
    SERVER_UNKNOWN_ERROR(50001, "服务端异常, 请稍后再试");

    private final int code;
    private final String message;
    private static final ImmutableMap<Integer, TccStatusCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, TccStatusCode> builder = ImmutableMap.builder();
        for (TccStatusCode statusCode : values()) {
            builder.put(statusCode.code(), statusCode);
        }
        CACHE = builder.build();
    }

    TccStatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static TccStatusCode valueOfCode(int code) {
        final TccStatusCode status = CACHE.get(code);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }
        return status;
    }

    @Override
    public int code() {
        return 0;
    }

    @Override
    public String message() {
        return message;
    }
}
