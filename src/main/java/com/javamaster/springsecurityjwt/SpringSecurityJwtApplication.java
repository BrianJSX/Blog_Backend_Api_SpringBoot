package com.javamaster.springsecurityjwt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringSecurityJwtApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}
	@Bean
    public CommandLineRunner mappingDemo() {
        return args -> {
          
        };
    }

}
