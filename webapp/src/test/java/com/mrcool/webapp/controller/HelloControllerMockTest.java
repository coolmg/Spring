package com.mrcool.webapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerMockTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void sayHello() throws Exception {
		this.mockMvc.perform(get("/hello").accept(MediaType.TEXT_HTML)).andExpect(status().isOk())
				.andExpect(view().name("hello")).andExpect(model().attribute("user", "World"));
	}

	@Test
	void sayHelloWithParam() throws Exception {
		this.mockMvc.perform(get("/hello").param("name", "Dolly").accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk()).andExpect(view().name("hello"))
				.andExpect(model().attribute("user", "Dolly"));
	}

}
