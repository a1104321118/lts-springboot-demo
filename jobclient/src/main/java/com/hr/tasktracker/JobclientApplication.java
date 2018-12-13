package com.hr.tasktracker;

import com.github.ltsopensource.spring.boot.annotation.EnableJobClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJobClient
public class JobclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobclientApplication.class, args);
	}
}
