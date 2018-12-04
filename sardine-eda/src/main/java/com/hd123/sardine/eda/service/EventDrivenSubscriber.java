package com.hd123.sardine.eda.service;

import com.google.common.base.Preconditions;
import com.hd123.sardine.eda.api.EventHandler;
import com.hd123.sardine.eda.api.EventStatus;
import com.hd123.sardine.eda.api.EventSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

public class EventDrivenSubscriber {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventDrivenSubscriber.class);

    @Autowired
    private EventSubscriberDao subscriberMapper;
    @Autowired
    private EventHandler handler;

    @PostConstruct
    private void afterProperties() {
        Preconditions.checkState(handler != null, "root EventHandler MUST not be null");
    }

    @Transactional(rollbackFor = Exception.class)
    public int persistAndHandleMessage(String businessType, String payload, String guid) {
        Preconditions.checkNotNull(businessType);
        Preconditions.checkNotNull(payload);
        Preconditions.checkNotNull(guid);
        final EventSubscriber subscriber = new EventSubscriber();
        subscriber.setBussinessType(businessType);
        subscriber.setPayload(payload);
        subscriber.setGuid(guid);
        subscriber.setLockVersion(0);
        subscriber.setStatus(EventStatus.NEW);
        int influence = 0;
        try {
            influence = subscriberMapper.insertSelective(subscriber);
        } catch (DuplicateKeyException e) {
            LOGGER.info("duplicate key in processing message '{}'", guid);
        }
        // 非重复消息则执行实际的业务
        if (influence > 0) {
            handler.handle(subscriber);
        }
        return influence;
    }
}
