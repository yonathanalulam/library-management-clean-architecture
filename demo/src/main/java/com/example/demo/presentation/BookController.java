package com.example.demo.presentation;

import com.example.demo.application.*;
import com.example.demo.domain.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookCommandHandler commandHandler;
    private final BookQueryHandler queryHandler;

    public BookController(BookCommandHandler commandHandler, BookQueryHandler queryHandler) {
        this.commandHandler = commandHandler;
        this.queryHandler = queryHandler;
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody AddBookCommand command) {
        String bookId = commandHandler.handle(command);
        return ResponseEntity.ok(bookId);
    }

    @PostMapping("/{id}/borrow")
    public ResponseEntity<Void> borrowBook(@PathVariable String id) {
        commandHandler.handle(new BorrowBookCommand(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        Book book = queryHandler.handle(new GetBookByIdQuery(id));
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = queryHandler.handle(new GetAllBooksQuery());
        return ResponseEntity.ok(books);
    }
}