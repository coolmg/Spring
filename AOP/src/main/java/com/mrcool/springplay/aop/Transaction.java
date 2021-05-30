/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.springplay.aop;

import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Component;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.0.0
 */
@Log4j2
@Component
public class Transaction {

	@Loggable
	public void create() {
		log.info("created");
	}

	@Loggable
	public void update() {
		log.info("updated");
	}

	@Loggable
	public void delete() {
		log.info("deleted");
	}

}
