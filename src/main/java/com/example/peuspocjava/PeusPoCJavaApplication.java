package com.example.peuspocjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PeusPoCJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeusPoCJavaApplication.class, args);
    }

}
