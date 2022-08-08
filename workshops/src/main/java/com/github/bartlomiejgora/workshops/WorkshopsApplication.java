package com.github.bartlomiejgora.workshops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WorkshopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopsApplication.class, args);
	}

}
