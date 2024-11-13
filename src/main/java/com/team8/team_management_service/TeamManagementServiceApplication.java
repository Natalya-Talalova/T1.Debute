package com.team8.team_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@EnableFeignClients
public class TeamManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamManagementServiceApplication.class, args);
		System.out.println("Swagger UI: http://localhost:8765/team-service/swagger-ui.html");
	}

}
