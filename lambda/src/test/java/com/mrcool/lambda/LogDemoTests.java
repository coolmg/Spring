/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.0.0
 */
public class LogDemoTests {

	@Test
	void test() throws IOException {
		long result = Files.lines(Path.of("src/main/resources/sample-access.log")).count();
		System.out.println("Found " + result + " lines in the log file.");
	}

	@Test
	void testFilter() throws IOException {
		long result = Files.lines(Path.of("src/main/resources/sample-access.log")).filter(line -> line.contains("GET"))
				.count();
		System.out.println("Found " + result + " lines in the log file.");

		result = Files.lines(Path.of("src/main/resources/sample-access.log"))
				.filter(line -> line.contains("130.211.62.52")).count();
		System.out.println("Found " + result + " requests from " + "130.211.62.52" + ".");
	}

}
