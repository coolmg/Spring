/*
 * Copyright 2021-2021 MrCool.
 *
 */
package com.mrcool.dp.observer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class WeatherDataTest {

	@Test
	void testMonitor() throws InterruptedException {

		WeatherData weatherData = new WeatherData();

		CurrentConditionsDisplay display1 = new CurrentConditionsDisplay(weatherData);

		Random random = new Random();

		int count = 0;
		while (10 != count) {
			++count;
			weatherData.setMeasurements(random.nextInt(100), random.nextInt(100), random.nextInt(100));
			TimeUnit.SECONDS.sleep(2);
		}

		weatherData.removeObserver(display1);
	}

}
