package com.mrcool.webapp;

import com.mrcool.webapp.json.Greeting;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyWebApplicationTest {

	@Autowired
	ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		assertNotNull(this.applicationContext);

		System.out.println(this.applicationContext.getBeanDefinitionCount());
		Arrays.stream(this.applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
	}

	@Test
	@Disabled
	void noGreetingInAppContext() {
		assertThrows(NoSuchBeanDefinitionException.class, () -> this.applicationContext.getBean(Greeting.class));
	}

	@Test
	void greetingBeanTwice() {
		Greeting greeting1 = this.applicationContext.getBean(Greeting.class);
		Greeting greeting2 = this.applicationContext.getBean(Greeting.class);

		assertNotNull(greeting1);
		assertNotNull(greeting2);

		System.out.println(greeting1.getMessage());

		greeting1.setMessage("Hello!");
		assertEquals(greeting1.getMessage(), greeting2.getMessage());

		assertSame(greeting1, greeting2);

	}

}