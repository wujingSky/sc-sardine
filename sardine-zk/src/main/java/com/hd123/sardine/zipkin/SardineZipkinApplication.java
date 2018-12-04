package com.hd123.sardine.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
@EnableZipkinStreamServer
public class SardineZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(SardineZipkinApplication.class, args);
    }
}
