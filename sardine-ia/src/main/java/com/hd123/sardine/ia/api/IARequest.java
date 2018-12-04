package com.hd123.sardine.ia.api;

import com.hd123.sardine.common.model.RestfulResponse;

public class IARequest extends RestfulResponse{

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
