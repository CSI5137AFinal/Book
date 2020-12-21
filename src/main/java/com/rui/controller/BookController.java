package com.rui.controller;

import com.rui.entity.Book;
import com.rui.repository.BookRepository;
import com.rui.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

//    @ResponseBody
//    @GetMapping("/findAll/{page}/{size}")
//    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return bookRepository.findAll(pageable);
//    }

    @GetMapping("/findAll")
    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Book book) {
        Book save = bookService.saveBook(book);
        return ResponseEntity.created(URI.create("/api/book/" + book.getId())).build();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable("id") Integer id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookRepository.deleteById(id);
            return ResponseEntity.ok(null);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") Integer id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

//    @PutMapping("/update")
//    public String update(@RequestBody Book book) {
//        Book save = bookRepository.save(book);
//        if (save != null) {
//            return "success";
//        } else {
//            return "error";
//        }
//    }

}
