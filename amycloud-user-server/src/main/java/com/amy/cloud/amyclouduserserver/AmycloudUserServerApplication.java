package com.amy.cloud.amyclouduserserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AmycloudUserServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmycloudUserServerApplication.class, args);
    }

}
