package com.hd123.sardine.tcc.api;

import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.time.OffsetDateTime;

/***
 * @author Jing
 */
public class TccParticipant implements Serializable{
    private static final long serialVersionUID = -1816632687832278753L;

    private String uri;
    private OffsetDateTime expireTime;
    private OffsetDateTime executeTime;
    private ResponseEntity<?> errorResponse;
    private TccStatus status = TccStatus.TO_BE_CONFIRMED;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public OffsetDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(OffsetDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public OffsetDateTime getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(OffsetDateTime executeTime) {
        this.executeTime = executeTime;
    }

    public ResponseEntity<?> getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ResponseEntity<?> errorResponse) {
        this.errorResponse = errorResponse;
    }

    public TccStatus getStatus() {
        return status;
    }

    public void setStatus(TccStatus status) {
        this.status = status;
    }
}
