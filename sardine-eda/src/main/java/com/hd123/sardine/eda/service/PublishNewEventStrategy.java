package com.hd123.sardine.eda.service;

import com.hd123.sardine.eda.api.EventPublisher;
import com.hd123.sardine.eda.api.EventStatus;

import java.util.Set;

public enum PublishNewEventStrategy implements BatchFetchEventStrategy {
    SINGLETON;

    @Override
    public Set<EventPublisher> execute(EventPublisherDao pubilsher) {
        return pubilsher.selectLimitedEntityByEventStatus(EventStatus.NEW,300);
    }
}
