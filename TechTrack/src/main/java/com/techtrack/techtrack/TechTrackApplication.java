package com.techtrack.techtrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages={
        "com.techtrack.*"})
public class TechTrackApplication{

    public static void main(String[] args) {
        SpringApplication.run(TechTrackApplication.class, args);
    }

}
