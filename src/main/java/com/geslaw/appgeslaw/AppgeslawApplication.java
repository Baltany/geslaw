package com.geslaw.appgeslaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.flywaydb.core.Flyway;

@SpringBootApplication
public class AppgeslawApplication {

	public static void main(String[] args) {

		Flyway flwy = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/indicadores","root","").load();

		flwy.migrate();


		SpringApplication.run(AppgeslawApplication.class, args);
	}

}
