package com.mrcool.webapp.services;

import com.mrcool.webapp.json.Site;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class GeocoderServiceTest {

	@Autowired
	GeocoderService geocoderService;

	@Test
	void getLatLng() {
		Site site = this.geocoderService.getLatLng("Boston", "MA");
		log.info(site.toString());

		assertAll(() -> assertEquals(42.36, site.getLatitude(), 0.01),
				() -> assertEquals(-71.06, site.getLongitude(), 0.01));
	}

	@Test
	void getLatLngWithStreet() {
		Site site = this.geocoderService.getLatLng("1600 Amphitheatre Parkway","Mountain View", "CA");
		log.info(site.toString());

		assertAll(() -> assertEquals(37.42, site.getLatitude(), 0.01),
				() -> assertEquals(-122.08, site.getLongitude(), 0.01));
	}

}