package com.mrcool.webapp.controller;

import com.mrcool.webapp.json.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloRestControllerTest {

	@Autowired
	private TestRestTemplate template;

	@Test
	void greetWithName() {
		Greeting greeting = this.template.getForObject("/rest/?name=Dolly", Greeting.class);
		assertEquals("Hello, Dolly!", greeting.getMessage());
	}

	@Test
	void greetWithoutName() {
		ResponseEntity<Greeting> entity = this.template.getForEntity("/rest", Greeting.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());

		assertEquals("Hello, World!", Objects.requireNonNull(entity.getBody()).getMessage());

	}

}