package com.msefectivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.persistencia.repository")
@EntityScan("com.persistencia.entity")
public class MsEfectivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEfectivoApplication.class, args);
	}

}
