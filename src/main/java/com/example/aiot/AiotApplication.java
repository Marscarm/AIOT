package com.example.aiot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AiotApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiotApplication.class, args);
    }

}
