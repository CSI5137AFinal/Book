package com.rui.repository;


import com.rui.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll() {
        System.out.println(bookRepository.findAll());
    }

    @Test
    void save() {
        Book book = new Book();
        book.setName("Java1");
        book.setAuthor("Rui");
        System.out.println(book.getId());
        Book save = bookRepository.save(book);
        System.out.println(save);
    }
}