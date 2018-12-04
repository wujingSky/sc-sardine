package com.hd123.sardine.ia.controller.client;

import com.hd123.sardine.ia.api.TccRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sardine-tcc", fallback = TccClient.TccClientFallback.class)
public interface TccClient {
    String API_PATH = "/api/v1/tcc";

    @RequestMapping(value = API_PATH + "/confirmation", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    void confirm(@RequestBody TccRequest request);

    @RequestMapping(value = API_PATH + "/cancellation", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    void cancel(@RequestBody TccRequest request);

    @Component
    class TccClientFallback implements TccClient {
        private static final Logger LOGGER = LoggerFactory.getLogger(TccClient.TccClientFallback.class);
        @Override
        public void confirm(TccRequest request) {

        }

        @Override
        public void cancel(TccRequest request) {
            //TODO
        }
    }
}
