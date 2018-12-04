package com.hd123.sardine.tcc.config;

import com.hd123.sardine.tcc.controller.TccResponseErrorHandler;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new TccResponseErrorHandler());
        return restTemplate;
    }
}
