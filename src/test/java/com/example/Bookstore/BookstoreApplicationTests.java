package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.web.BookstoreController;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreApplicationTests {
	@Autowired
	private BookstoreController controller;
	
	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}
