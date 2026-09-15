package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages="com.cgi" )
@EnableAutoConfiguration
public class CgiDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgiDemoProjectApplication.class, args);
	}

}
