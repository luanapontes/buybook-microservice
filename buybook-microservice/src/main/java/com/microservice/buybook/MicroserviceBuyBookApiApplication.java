package com.microservice.buybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroserviceBuyBookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBuyBookApiApplication.class, args);
	}

}
