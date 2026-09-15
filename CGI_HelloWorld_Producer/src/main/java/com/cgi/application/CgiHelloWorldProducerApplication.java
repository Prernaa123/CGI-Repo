package com.cgi.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@ComponentScan("com.cgi.rest")
@EnableAutoConfiguration

public class CgiHelloWorldProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgiHelloWorldProducerApplication.class, args);
	}

}
