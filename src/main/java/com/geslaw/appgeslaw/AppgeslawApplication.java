package com.geslaw.appgeslaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppgeslawApplication {

	public static void main(String[] args) {

		// Flyway flwy = Flyway.configure().dataSource("jdbc:mysql://localhost:8080/indicadores","root","root").load();

		// flwy.migrate();


		SpringApplication.run(AppgeslawApplication.class, args);
	}

}
