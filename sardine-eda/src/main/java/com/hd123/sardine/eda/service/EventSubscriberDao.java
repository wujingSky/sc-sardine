package com.hd123.sardine.eda.service;

import com.hd123.sardine.common.service.CrudDao;
import com.hd123.sardine.common.service.CrudService;
import com.hd123.sardine.eda.api.EventStatus;
import com.hd123.sardine.eda.api.EventSubscriber;
import org.apache.ibatis.annotations.Param;

public interface EventSubscriberDao extends CrudDao<EventSubscriber> {
    int updateEventStatusByPrimaryKeyInCasMode(@Param("id") Long id, @Param("expect") EventStatus expect, @Param("target") EventStatus target);
}
