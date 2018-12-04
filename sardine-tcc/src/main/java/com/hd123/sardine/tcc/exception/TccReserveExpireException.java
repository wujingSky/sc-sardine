package com.hd123.sardine.tcc.exception;

import com.hd123.sardine.tcc.api.TccErrorResponse;

public class TccReserveExpireException extends RuntimeException {
    private static final long serialVersionUID = 3665563233664481931L;

    private TccErrorResponse errorResponse;

    public TccReserveExpireException(String message) {
        super(message);
    }

    public TccReserveExpireException(String message, TccErrorResponse errorResponse) {
        super(message);
        this.errorResponse = errorResponse;
    }

    public TccReserveExpireException(String message, Throwable cause) {
        super(message, cause);
    }

    public TccReserveExpireException(Throwable cause) {
        super(cause);
    }

    protected TccReserveExpireException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TccErrorResponse getErrorResponse() {
        return errorResponse;
    }
}