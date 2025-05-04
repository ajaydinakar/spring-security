package com.ajay.springsecurity1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Springsecurity1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springsecurity1Application.class, args);
	}

}
