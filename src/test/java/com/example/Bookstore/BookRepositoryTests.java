package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository repository;
    

    @Test
    public void getTitleShouldReturnBook() {
        List<Book> books = repository.findByAuthor("Harper Lee");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("To Kill A Mockingbird");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Brief Answers to Big Questions", "Stephen Hawking", 2000, 10289301, 100, new Category("Science"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    
    @Test
    public void deleteBook() {
    	List<Book> books = repository.findByAuthor("Harper Lee");
    	books.remove(books.get(0));
    	assertThat(books).hasSize(0);
    }

}
