package com.hd123.sardine.tcc.exception;

import com.hd123.sardine.tcc.api.TccErrorResponse;

public class TccReserveAlmostExpireException extends RuntimeException {
    private static final long serialVersionUID = 3665563233664481931L;

    private TccErrorResponse errorResponse;

    public TccReserveAlmostExpireException(String message) {
        super(message);
    }

    public TccReserveAlmostExpireException(String message, TccErrorResponse errorResponse) {
        super(message);
        this.errorResponse = errorResponse;
    }

    public TccReserveAlmostExpireException(String message, Throwable cause) {
        super(message, cause);
    }

    public TccReserveAlmostExpireException(Throwable cause) {
        super(cause);
    }

    protected TccReserveAlmostExpireException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TccErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
