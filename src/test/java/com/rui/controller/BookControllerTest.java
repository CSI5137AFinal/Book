package com.rui.controller;

import com.rui.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BookControllerTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll() {
        int pageNum = 2;
        int pageSize = 10;
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }
}