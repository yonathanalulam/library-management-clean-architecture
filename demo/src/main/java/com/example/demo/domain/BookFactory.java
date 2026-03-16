package com.example.demo.domain;

import java.util.UUID;

public class BookFactory {
    public static Book createNewBook(String title, String author) {
        return new Book(UUID.randomUUID().toString(), title, author, true);
    }
}