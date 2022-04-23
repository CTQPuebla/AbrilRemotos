package com.msefectivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.cajero.repository")
@EntityScan("com.cajero.entity")
public class MsEfectivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEfectivoApplication.class, args);
	}

}
