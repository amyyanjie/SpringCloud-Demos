package com.amy.cloud.amycloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication //整合了@SpringBootApplication，@EnableDiscoveryClient，@EnableCircuitBreaker(开启熔断器功能)
public class AmycloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmycloudGatewayApplication.class, args);
    }

}
