package com.e_commerce.coustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoustomerApplication.class, args);
	}

}
