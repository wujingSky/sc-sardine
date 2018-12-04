package com.hd123.sardine.ia.controller.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "sardine-wms", fallback = WMSClient.WMSClientFallback.class)
public interface WMSClient {
        @GetMapping(value = "/wms")
        String printWMSService();

@Component
class WMSClientFallback implements WMSClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(WMSClientFallback.class);

    @Override
    public String printWMSService() {
        LOGGER.info("异常发生，进入fallback方法");
        return "SERVICE B FAILED! - FALLING BACK";
    }
}
}
