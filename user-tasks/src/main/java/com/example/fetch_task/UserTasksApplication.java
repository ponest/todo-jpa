package com.example.fetch_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients()
public class UserTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserTasksApplication.class, args);
	}

}
