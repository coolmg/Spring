/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.lambda;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.0.0
 */
class MyStreamsTests {

	@Test
	void test() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Ann");
		names.add("Barry");
		names.add("Cixin");
		names.add("Dante");

		names.stream().forEach(System.out::println);
		assertThat(names.stream().count()).isEqualTo(4);
	}

}
