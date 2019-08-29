package com.amy.cloud.amyclouduserclient;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public class AmycloudUserClientConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(AmycloudUserClientConfiguration.class, args);
    }

}
