package com.example.rest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.example.rest","com.example.restmodule","com.example.api","com.example.dto","com.example.cloud"})
public class RestApplication {


	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
