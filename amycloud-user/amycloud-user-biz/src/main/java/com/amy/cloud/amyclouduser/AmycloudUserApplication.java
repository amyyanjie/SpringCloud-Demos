package com.amy.cloud.amyclouduser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AmycloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmycloudUserApplication.class, args);
    }

}
