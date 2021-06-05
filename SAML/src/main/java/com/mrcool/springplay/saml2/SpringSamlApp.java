/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.springplay.saml2;

import lombok.extern.log4j.Log4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.0.0
 */
@Log4j2
@SpringBootApplication
public class SpringSamlApp implements ApplicationListener {

	public static void main(String[] args) {
		SpringApplication.run(SpringSamlApp.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		log.info(event.toString());
	}

}
