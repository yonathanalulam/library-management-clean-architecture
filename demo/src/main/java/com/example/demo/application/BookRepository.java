package com.example.demo.application;

import com.example.demo.domain.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void save(Book book);
    Optional<Book> findById(String id);
    List<Book> findAll();
}