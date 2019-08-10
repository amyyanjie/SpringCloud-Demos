package com.amy.cloud.amycloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class AmycloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmycloudEurekaApplication.class, args);
	}

}
