package com.hd123.sardine.tcc.controller.advice;

import com.google.common.collect.ImmutableMap;
import com.hd123.sardine.common.RestStatus;
import com.hd123.sardine.common.exception.RestStatusException;
import com.hd123.sardine.common.model.ErrorEntity;
import com.hd123.sardine.common.web.RequestAttributeConst;
import com.hd123.sardine.tcc.api.TccErrorResponse;
import com.hd123.sardine.tcc.api.TccStatusCode;
import com.hd123.sardine.tcc.exception.TccConfirmException;
import com.hd123.sardine.tcc.exception.TccReserveAlmostExpireException;
import com.hd123.sardine.tcc.exception.TccReserveExpireException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class FaultBarrier {
    private static final Logger LOGGER = LoggerFactory.getLogger(FaultBarrier.class);
    private static final ImmutableMap<Class<? extends Throwable>, RestStatus> EXCEPTION_MAPPINGS;

    @Value("${spring.application.name}")
    private String applicationName;

    static {
        final ImmutableMap.Builder<Class<? extends Throwable>, RestStatus> builder = ImmutableMap.builder();
        builder.put(MethodArgumentTypeMismatchException.class, TccStatusCode.INVALID_PARAMS_CONVERSION);
        builder.put(UnsatisfiedServletRequestParameterException.class, TccStatusCode.INVALID_PARAMS_CONVERSION);
        builder.put(HttpRequestMethodNotSupportedException.class, TccStatusCode.REQUEST_METHOD_NOT_SUPPORTED);
        builder.put(HttpMessageNotReadableException.class, TccStatusCode.HTTP_MESSAGE_NOT_READABLE);
        builder.put(Exception.class, TccStatusCode.SERVER_UNKNOWN_ERROR);
        EXCEPTION_MAPPINGS = builder.build();
    }

    @ResponseBody
    @ExceptionHandler(RestStatusException.class)
    public Object restStatusException(Exception e, HttpServletRequest request) {
        return request.getAttribute(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object illegalValidateException(Exception e, HttpServletRequest request) {
        return request.getAttribute(e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({TccReserveExpireException.class, TccReserveAlmostExpireException.class})
    public void expireReservationException(Exception e, HttpServletRequest request) {
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(TccConfirmException.class)
    public Object partialConfirmException(TccConfirmException e, HttpServletRequest request) {
        final TccErrorResponse error = e.getErrorResponse();
        return new ErrorEntity(TccStatusCode.RESERVATION_CONFLICT, error);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ErrorEntity exception(Exception e, HttpServletRequest request) {
        LOGGER.error("request id: {}\r\nexception: {}", request.getAttribute(RequestAttributeConst.REQUEST_ID), e);
        final RestStatus status = EXCEPTION_MAPPINGS.get(e.getClass());
        ErrorEntity error;
        if (status != null) {
            error = new ErrorEntity(status);
        } else {
            error = new ErrorEntity(TccStatusCode.SERVER_UNKNOWN_ERROR);
            if (e instanceof IllegalStateException) {
                if (e.getMessage().contains("No instances available for " + applicationName)) {
                    error = new ErrorEntity(TccStatusCode.SERVICE_INITIALIZING);
                }
            }
        }
        return error;
    }

}
