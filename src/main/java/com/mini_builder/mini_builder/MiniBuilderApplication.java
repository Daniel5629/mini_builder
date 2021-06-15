package com.mini_builder.mini_builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MiniBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniBuilderApplication.class, args);
	}
}
