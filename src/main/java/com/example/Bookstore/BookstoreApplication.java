package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.Customer;
import com.example.Bookstore.domain.CustomerRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, CustomerRepository urepository) {
		return (args) -> {
			log.info("save a couple of categories");
			crepository.save(new Category("Classic"));
			crepository.save(new Category("Non-fiction"));
			crepository.save(new Category("Fiction"));
			
			
			log.info("save a couple of books");
			brepository.save(new Book("To Kill A Mockingbird", "Harper Lee", 2010, 1001, 150, crepository.findByName("Fiction").get(0)));
			brepository.save(new Book("Great Expectations", "Charles Dickens", 2000, 1002, 200, crepository.findByName("Classic").get(0)));
			
			Customer customer1 = new Customer("student", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "STUDENT", "user@booklist.com");
			Customer customer2 = new Customer("teacher", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin@booklist.com");
			urepository.save(customer1);
			urepository.save(customer2);

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};

	}
}
