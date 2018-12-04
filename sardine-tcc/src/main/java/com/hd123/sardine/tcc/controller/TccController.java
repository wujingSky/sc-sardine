package com.hd123.sardine.tcc.controller;

import com.hd123.sardine.tcc.api.TccRequest;
import com.hd123.sardine.tcc.api.TccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class TccController {
    private static final String TCC_URI_PREFIX = "/tcc";

    @Autowired
    private TccService tccService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = TCC_URI_PREFIX + "/confirmation", method = RequestMethod.PUT)
    public void confirm(@Valid @RequestBody TccRequest request, BindingResult result) throws Exception {
        tccService.confirm(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = TCC_URI_PREFIX + "/cancellation", method = RequestMethod.PUT)
    public void cancel(@Valid @RequestBody TccRequest request, BindingResult result) {
            tccService.cancel(request);
    }

}
