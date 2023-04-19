package com.helpdesk_ticketing_system.solutions_data_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class SolutionsDataManagementApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SolutionsDataManagementApplication.class);
		application.setDefaultProperties(Collections
				.singletonMap("server.port", System.getenv("tomcat_server_port")));
		application.run(args);
	}

}
