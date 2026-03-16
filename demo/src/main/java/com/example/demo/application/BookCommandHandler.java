package com.example.demo.application;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookFactory;
import org.springframework.stereotype.Service;

@Service
public class BookCommandHandler {
    private final BookRepository repository;

    public BookCommandHandler(BookRepository repository) {
        this.repository = repository;
    }

    public String handle(AddBookCommand command) {
        Book newBook = BookFactory.createNewBook(command.title(), command.author());
        repository.save(newBook);
        return newBook.getId();
    }

    public void handle(BorrowBookCommand command) {
        Book book = repository.findById(command.bookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!book.isAvailable()) {
            throw new RuntimeException("Book is already borrowed");
        }

        book.setAvailable(false);
        repository.save(book);
    }
}