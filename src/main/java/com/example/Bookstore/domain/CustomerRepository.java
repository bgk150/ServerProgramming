package com.example.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Customer findByUsername(String username);
}
