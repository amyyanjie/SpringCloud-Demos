package com.amy.cloud.amycloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication //整合了@SpringBootApplication，@EnableDiscoveryClient，@EnableCircuitBreaker(开启熔断器功能)
public class AmycloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmycloudZuulApplication.class, args);
    }

}
