package com.hd123.sardine.eda.api;

import com.hd123.sardine.eda.service.EventSubscriberDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class EventHandler {
    @Autowired
    private EventSubscriberDao mapper;

    public EventSubscriberDao getMapper() {
        return mapper;
    }

    public void setMapper(EventSubscriberDao mapper) {
        this.mapper = mapper;
    }

    public abstract void handle(EventSubscriber subscriber);

}
