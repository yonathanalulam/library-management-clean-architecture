package com.example.demo.infrastructure;

import com.example.demo.application.BookRepository;
import com.example.demo.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBookRepository implements BookRepository {
    private final Map<String, Book> store = new ConcurrentHashMap<>();

    @Override
    public void save(Book book) {
        store.put(book.getId(), book);
    }

    @Override
    public Optional<Book> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }
}