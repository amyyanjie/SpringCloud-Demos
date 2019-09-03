package com.amy.cloud.amycloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class AmycloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmycloudGatewayApplication.class, args);
    }

}
