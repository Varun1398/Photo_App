package com.appsdeveblog.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackageClasses= UserEntity.class)
public class MobileAppWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileAppWsApplication.class, args);
    }

}
