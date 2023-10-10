package com.rachacartaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
public class IndikyAppServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(IndikyAppServerApplication.class, args);
	}

}
