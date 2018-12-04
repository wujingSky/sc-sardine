package com.hd123.sardine.eda.service;

import com.hd123.sardine.eda.api.EventPublisher;
import com.hd123.sardine.eda.api.EventStatus;

import java.time.OffsetDateTime;
import java.util.Set;

public enum RepublishPendingEventStrategy implements BatchFetchEventStrategy {
    SINGLETON;

    @Override
    public Set<EventPublisher> execute(EventPublisherDao pubilsher) {
        return pubilsher.selectLimitedEntityByEventStatusBeforeTheSpecifiedUpdateTime(EventStatus.PENDING,300, OffsetDateTime.now().minusSeconds(3));
    }
}
