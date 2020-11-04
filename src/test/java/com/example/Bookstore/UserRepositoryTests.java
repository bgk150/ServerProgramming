package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;
    

    @Test
    public void findByUsernameShouldReturnUser() {
        User user = repository.findByUsername("student");
        
        assertThat(user.getPasswordHash()).isEqualTo("$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6");
    }
    
    @Test
    public void createUser() {
    	User user = new User("chandlerbing", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "chandler.bing@gmail.com");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }    
    

}
