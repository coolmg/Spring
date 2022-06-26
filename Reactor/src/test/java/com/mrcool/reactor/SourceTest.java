package com.mrcool.reactor;

import org.junit.jupiter.api.Test;
import org.reactivestreams.tck.TestEnvironment;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SourceTest {

	@Test
	void test2() {
		// new FibonacciPublisherVerifier(new TestEnvironment());
	}

	@Test
	void testFibonacci() {
		Flux<Long> fibonacciGenerator = Flux.generate(() -> Tuples.of(0L, 1L), (state, sink) -> {
			sink.next(state.getT1());
			return Tuples.of(state.getT2(), state.getT1() + state.getT2());
		});
		List<Long> fibonacciSeries = new LinkedList<>();
		int size = 50;
		fibonacciGenerator.take(size).subscribe(fibonacciSeries::add);
		System.out.println(fibonacciSeries);
		assertEquals(7778742049L, fibonacciSeries.get(size - 1).longValue());
	}

}