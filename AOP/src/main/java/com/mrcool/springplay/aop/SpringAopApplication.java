/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.springplay.aop;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringPlay AOP demo application.
 *
 * @author Mahendra Gadila
 * @since 1.0.0
 */
@Log4j2
@SpringBootApplication
public class SpringAopApplication {

	public void init() {
		log.info("");
	}

	public static void main(String[] args) {
		log.info("Starting AOP Application");
		SpringApplication.run(SpringAopApplication.class, args);
	}

}
