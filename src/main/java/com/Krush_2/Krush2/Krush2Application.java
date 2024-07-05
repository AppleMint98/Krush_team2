package com.Krush_2.Krush2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Krush2Application {

	public static void main(String[] args) {
		SpringApplication.run(Krush2Application.class, args);
	}

}
