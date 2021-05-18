package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(AlumnoRepository repository) {
		return (args) -> {


			// fetch all customers
			log.info("Alumnos found with findAll():");
			log.info("-------------------------------");
			for (Alumno Alumno : repository.findAll()) {
				log.info(Alumno.toString());
			}
			log.info("");


		};
	}

}