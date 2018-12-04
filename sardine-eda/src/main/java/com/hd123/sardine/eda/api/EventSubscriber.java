package com.hd123.sardine.eda.api;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.hd123.sardine.common.model.BasicDomain;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class EventSubscriber extends BasicDomain{
    @NotNull
    @NotBlank
    private String bussinessType;

    @NotNull
    private EventStatus status;

    @NotNull
    private String payload;

    @NotNull
    private Integer lockVersion;
    @NotNull
    private String guid;

    public String getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(String bussinessType) {
        this.bussinessType = bussinessType;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Integer getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
