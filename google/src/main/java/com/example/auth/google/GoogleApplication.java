package com.example.auth.google;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GoogleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoogleApplication.class, args);
    }

}
