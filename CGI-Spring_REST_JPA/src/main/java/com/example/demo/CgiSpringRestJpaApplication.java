package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaRepositories("com.cgi.repo")
@EntityScan("com.cgi.entity")
@EnableWebMvc
@ComponentScan("com.cgi")
@EnableAutoConfiguration
@SpringBootApplication
public class CgiSpringRestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgiSpringRestJpaApplication.class, args);
	}
	
	

}
