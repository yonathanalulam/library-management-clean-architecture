package com.example.demo.application;

import com.example.demo.domain.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookQueryHandler {
    private final BookRepository repository;

    public BookQueryHandler(BookRepository repository) {
        this.repository = repository;
    }

    public Book handle(GetBookByIdQuery query) {
        return repository.findById(query.id())
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> handle(GetAllBooksQuery query) {
        return repository.findAll();
    }
}