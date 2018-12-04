package com.hd123.sardine.eda.service;

import com.hd123.sardine.eda.api.EventPublisher;
import com.hd123.sardine.eda.service.EventPublisherDao;

import java.util.Set;

public interface BatchFetchEventStrategy {

    Set<EventPublisher> execute(EventPublisherDao pubilsher);
}
