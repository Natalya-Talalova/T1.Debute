package com.team8.team_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeamManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamManagementServiceApplication.class, args);
		System.out.println("Swagger UI: http://localhost:8080/swagger-ui.html");
	}

}
