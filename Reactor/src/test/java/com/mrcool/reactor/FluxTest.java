package com.mrcool.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.stream.IntStream;

class FluxTest {

	@Test
	void testJust() {

		Flux flux1 = Flux.just("Red");
		Flux.just("Red", "Blue", "Yellow", "Black");
	}

	@Test
	void testFrom() {
		Flux.fromArray(new Integer[] { 1, 1, 2, 3, 5, 8, 13 });
		Flux.fromIterable(Arrays.asList("Red", "Blue", "Yellow", "Black"));
		Flux.fromStream(IntStream.range(1, 100).boxed());
	}

}
