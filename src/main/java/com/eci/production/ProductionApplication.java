package com.eci.production;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) //excludes security auto configuration
public class ProductionApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductionApplication.class, args);
	}

}
