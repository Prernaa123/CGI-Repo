package com.cgi.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.cgi")
@EnableJpaRepositories("com.cgi.repo")
@EntityScan("com.cgi.entity")
@EnableDiscoveryClient
public class CgiProductProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgiProductProducerApplication.class, args);
    }
}