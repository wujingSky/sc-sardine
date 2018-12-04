package com.hd123.sardine.common.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * @author Jing
 */
public class BasicDomain implements Serializable{
    private static final long serialVersionUID = 6401939125344686735L;

    private long id;
    private OffsetDateTime createTime;
    private OffsetDateTime updateTime;
    private OffsetDateTime deleteTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(OffsetDateTime createTime) {
        this.createTime = createTime;
    }

    public OffsetDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(OffsetDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public OffsetDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(OffsetDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }
}
