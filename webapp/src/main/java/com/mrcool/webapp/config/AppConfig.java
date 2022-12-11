package com.mrcool.webapp.config;

import com.mrcool.webapp.json.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

	@Bean
	@Primary
	public Greeting defaultGreeting() {
		return new Greeting("Hello, World!");
	}

	@Bean
	public Greeting whatsupGreeting() {
		return new Greeting("Hello, What up?");
	}

}
