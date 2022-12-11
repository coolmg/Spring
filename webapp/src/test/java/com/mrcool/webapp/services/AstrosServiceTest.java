package com.mrcool.webapp.services;

import com.mrcool.webapp.json.Astros;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstrosServiceTest {

	@Autowired
	AstrosService astrosService;

	@Test
	void getAstronauts() {
		Astros astros = this.astrosService.getAstronauts();

		System.out.println("People number:" + astros.getNumber());

		assertAll(() -> assertTrue(astros.getNumber() > 0),
				() -> assertEquals(astros.getNumber(), astros.getPeople().size()));
	}

	@Test
	void getAstronautsWc() {
		Astros astros = this.astrosService.getAstronautsWc();

		System.out.println("People number:" + astros.getNumber());

		assertAll(() -> assertTrue(astros.getNumber() > 0),
				() -> assertEquals(astros.getNumber(), astros.getPeople().size()));

	}

}