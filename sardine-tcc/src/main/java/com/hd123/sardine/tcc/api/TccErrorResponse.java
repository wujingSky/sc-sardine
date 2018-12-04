package com.hd123.sardine.tcc.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TccErrorResponse implements Serializable{
    public TccErrorResponse(List<TccParticipant> tps){
        this.items = tps;
    }

    private List<TccParticipant> items = new ArrayList<>();

    public List<TccParticipant> getItems() {
        return items;
    }

    public void setItems(List<TccParticipant> items) {
        this.items = items;
    }
}
