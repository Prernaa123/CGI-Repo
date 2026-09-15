package com.cgi.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class CgiEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgiEurekaServerApplication.class, args);
	}

}
