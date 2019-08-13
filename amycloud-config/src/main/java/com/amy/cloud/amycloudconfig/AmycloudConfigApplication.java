package com.amy.cloud.amycloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class AmycloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmycloudConfigApplication.class, args);
	}

}
