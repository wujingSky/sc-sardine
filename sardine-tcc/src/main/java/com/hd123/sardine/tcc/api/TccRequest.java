package com.hd123.sardine.tcc.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TccRequest implements Serializable{

    private List<TccParticipant> items = new ArrayList<>();

    public List<TccParticipant> getItems() {
        return items;
    }

    public void setItems(List<TccParticipant> items) {
        this.items = items;
    }
}
