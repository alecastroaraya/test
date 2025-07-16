package com.fullstacktest.fullstack;

import com.fullstacktest.fullstack.service.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	private Service service = new Service();

	@Test
	void contextLoads() {
	}

	@Test
	void allocateResources_returnsNonEmptyResults() {
		assertFalse(service.allocate(1, 100).isEmpty());
	}

}
