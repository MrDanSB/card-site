package com.example.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring boot application launcher
 * 
 * @author Daniel Phillips
 *
 */
@SpringBootApplication
@ComponentScan("com.example.cards")
public class CardsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
