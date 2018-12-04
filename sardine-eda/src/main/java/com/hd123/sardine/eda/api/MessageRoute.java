package com.hd123.sardine.eda.api;

import org.springframework.beans.factory.annotation.Value;

@lombok.Value
public class MessageRoute {

    private String exchange;
    private String routeKey;

    public MessageRoute(String exchange, String routeKey) {
        this.exchange = exchange;
        this.routeKey = routeKey;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }
}
