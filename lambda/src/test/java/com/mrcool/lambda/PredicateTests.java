/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.0.0
 */
public class PredicateTests {

	@Test
	void testEven() {
		IntStream incoming = IntStream.generate(() -> (int) (Math.random() * Integer.MAX_VALUE));
		incoming.filter(new IsItEven()).limit(10).forEach(System.out::println);
	}

	@Test
	void testLambda() {
		IntStream incoming = IntStream.generate(() -> (int) (Math.random() * Integer.MAX_VALUE));
		incoming.filter(value -> value % 2 == 0).limit(10).forEach(System.out::println);
	}

    @Test
    void testLambdaOdd() {
        IntStream incoming = IntStream.generate(() -> (int) (Math.random() * Integer.MAX_VALUE));
        IntPredicate even = value -> value % 2 == 0;
        incoming.filter(even.negate()).limit(10).forEach(System.out::println);
    }

    @Test
    void testLambdaLeap() {
        IntStream incoming = IntStream.generate(() -> (int)  (Math.random() * 201) + 1900);
        IntPredicate is4 = value -> value % 4 == 0;
        IntPredicate not100 = value -> value % 100 !=0;
        incoming.filter(is4.and(not100)).limit(10).forEach(System.out::println);
    }


}
