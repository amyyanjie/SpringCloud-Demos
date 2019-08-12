package com.amy.cloud.amycloudact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AmycloudActApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmycloudActApplication.class, args);
	}

}
