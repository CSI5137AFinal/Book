package com.rui.service.Impl;

import com.rui.entity.Book;
import com.rui.repository.BookRepository;
import com.rui.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book saveBook(Book newBook) {
        return bookRepository.save(newBook);
    }
}
