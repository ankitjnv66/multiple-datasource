package com.database.learning.multipledatasource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MultipleDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDatasourceApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {
			System.out.println("*************");
			System.out.println("testing multiple data source application!");
			System.out.println("*************");
		};
	}
}
