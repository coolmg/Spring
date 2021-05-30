/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.springplay;

import com.mrcool.springplay.aop.Transaction;
import lombok.extern.log4j.Log4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SpringPlay AOP demo application.
 *
 * @author Mahendra Gadila
 * @since 1.0.0
 */
@Log4j2
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringAopApplication implements ApplicationListener {

	public static void main(String[] args) {
		log.info("Starting AOP Application");
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringAopApplication.class, args);

		Transaction transaction = applicationContext.getBean(Transaction.class);
		transaction.update();
		transaction.create();
		transaction.delete();
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		log.info(event.toString());
	}

}
