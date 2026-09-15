package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com.cgi.*")
public class CgiRestSpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgiRestSpringJdbcApplication.class, args);
	}

}
