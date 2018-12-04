package com.hd123.sardine.ia.controller;

import com.hd123.sardine.ia.controller.client.WMSClient;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/ia")
public class IABaseController {

    private static final Logger LOG = Logger.getLogger(IABaseController.class.getName());
    private EurekaDiscoveryClient discoveryClient;
    @Autowired
    private WMSClient wmsClient;

    @GetMapping(value = "get")
    public String get() {
        LOG.log(Level.INFO, "calling get  ");
        return "Hello";
    }

   @GetMapping(value = "/")
    public String printIAService() {
        return wmsClient.printWMSService();
        /*ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance.getServiceId() + " (" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ")" + wmsClient.printWMSService();
*/    }
}
