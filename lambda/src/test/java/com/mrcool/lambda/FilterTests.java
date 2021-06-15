/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.lambda;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.0.0
 */
public class FilterTests {

	@Test
	void testIntSupplier() {
		IntStream incoming = IntStream.generate(new GiveMeAnInt());
		incoming.forEach(System.out::println);
	}

	@Test
	void testLimit() {
		IntStream incoming = IntStream.generate(new GiveMeAnInt());
		incoming.limit(10).forEach(System.out::println);
	}

	@Test
	void testLambda() {
		IntStream incoming = IntStream.generate(() -> (int) (Math.random() * Integer.MAX_VALUE));
		incoming.limit(10).forEach(System.out::println);
	}

	@Test
	void testPeek() {
		IntStream.generate(() -> (int) (Math.random() * 1000)).limit(10).peek(i -> System.out.println("Inbound: " + i))
				.filter(j -> j % 2 == 0).forEach(k -> System.out.println("Outbound: " + k));
	}

}
