package com.bootapps.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class EmployeeAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
	}
	
}
