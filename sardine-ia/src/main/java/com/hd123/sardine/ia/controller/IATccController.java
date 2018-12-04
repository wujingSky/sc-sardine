package com.hd123.sardine.ia.controller;

import com.hd123.sardine.common.model.RestfulResponse;
import com.hd123.sardine.ia.api.IARequest;
import com.hd123.sardine.ia.api.IAService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class IATccController {

    @Autowired
    private IAService iaService;

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public RestfulResponse<String> saveOrder(@Valid @RequestBody IARequest request, BindingResult result) {
        return iaService.save(request);
    }

    @RequestMapping(value = "/orders/confirmation", method = RequestMethod.POST)
    public RestfulResponse<String> confirmOrder(@Valid @RequestBody IARequest request, BindingResult result) {
        return iaService.confirm(request);
    }
}
