package com.example.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.cloud"})
@MapperScan("com.example.cloud.repository")
@SpringBootApplication
public class JmpCloudServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmpCloudServiceImplApplication.class, args);
    }

}
