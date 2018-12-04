package com.hd123.sardine.tcc.exception;

import com.hd123.sardine.tcc.api.TccErrorResponse;

public class TccConfirmException extends RuntimeException {
    private static final long serialVersionUID = 3665563233664481931L;

    private TccErrorResponse errorResponse;

    public TccConfirmException(String message) {
        super(message);
    }

    public TccConfirmException(String message, TccErrorResponse errorResponse) {
        super(message);
        this.errorResponse = errorResponse;
    }

    public TccConfirmException(String message, Throwable cause) {
        super(message, cause);
    }

    public TccConfirmException(Throwable cause) {
        super(cause);
    }

    protected TccConfirmException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TccErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
