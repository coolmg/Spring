package com.mrcool.webapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloControllerTest {

	@Test
	void sayHello() {
		HelloController controller = new HelloController();
		Model model = new ExtendedModelMap();
		String result = controller.sayHello("World", model);

		assertAll(() -> assertEquals("World", model.getAttribute("user")), () -> assertEquals("hello", result));
	}

}