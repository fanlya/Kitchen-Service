package com.pbkk.KitchenService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.pbkk")
@SpringBootApplication
public class KitchenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitchenServiceApplication.class, args);
	}

}
