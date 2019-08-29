package com.amy.cloud.amycloudact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan("com.amy.cloud")
public class AmycloudActApplication {
    private static ApplicationContext context;

    private static Environment env;

    public static void main(String[] args) {
        context = SpringApplication.run(AmycloudActApplication.class, args);
        env = context.getEnvironment();
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static Environment getEnv() {
        return env;
    }

}
