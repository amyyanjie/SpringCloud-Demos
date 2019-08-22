package com.amy.cloud.amycloudzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class AmycloudZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmycloudZipkinApplication.class, args);
    }

}
