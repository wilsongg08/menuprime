package com.menuprime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MenuprimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuprimeApplication.class, args);
	}

}
