/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.springplay.aop;

import java.util.Arrays;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.0.0
 */
@Log4j2
@Aspect
@Component
public class AspectLogs {

	@Before("@annotation(Loggable)")
	public void logBefore(JoinPoint joinPoint) {
		StringBuilder message = new StringBuilder("Method: ");
		message.append(joinPoint.getSignature().toShortString());
		Object[] args = joinPoint.getArgs();
		if (args != null && args.length > 0) {
			message.append("args=[");
			Arrays.asList(args).forEach(arg -> message.append("args=").append(arg));
		}
		message.append("]");
		log.info(message.toString());
	}

}
