/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.lambda;

import lombok.extern.log4j.Log4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.2.0
 */

@Log4j2
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void init() {
		log.info("Initialized");
	}

}
